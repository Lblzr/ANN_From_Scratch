package components;

import processes.ForwardPropagate;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents a block of neuron connections within a Neural Network
 */
public class ConnectionBlock {
    private final List<Neuron> leftLayer;
    private final List<Neuron> rightLayer;
    private List<List<Connection>> connections;
//    private final int neuron_count;

    /**
     * Constructor for ConnectionBlock.
     * Accepts an input layer and creates a specified number of neurons for the output layer.
     *
     * @param predefined_neurons List of input Neurons for this block
     * @param right_neuron_count number of Neurons to be created for the output layer
     */
    public ConnectionBlock(List<Neuron> predefined_neurons, int right_neuron_count) {
        this.leftLayer = new ArrayList<>(predefined_neurons);
        System.out.println("creating neurons");
        this.rightLayer = createNeurons(right_neuron_count);

        connections = createConnections(this.leftLayer, this.rightLayer);
    }

    /**
     * Constructor for ConnectionBlock.
     * Accepts both input and output layers.
     *
     * @param inputs List of input Neurons for this block
     * @param outputs List of output Neurons for this block
     */
    public ConnectionBlock(List<Neuron> inputs, List<Neuron> outputs) {

        this.leftLayer = new ArrayList<>(inputs);
        this.rightLayer = new ArrayList<>(outputs);

        connections = createConnections(this.leftLayer, this.rightLayer);
    }


    // Getters

    /**
     * Returns the input layer of this block
     *
     * @return List of Neurons present in the input layer
     */
    public List<Neuron> getInputLayer() {
        return leftLayer;
    }

    /**
     * Returns the output layer of this block
     *
     * @return List of Neurons present in the output layer
     */
    public List<Neuron> getOutputLayer() {
        return rightLayer;
    }

    /**
     * Returns all the neurons in this block
     *
     * @return List of all Neurons in this block
     */
    public List<Neuron> getAllNeurons() {
        List<Neuron> neurons = new ArrayList<>();
        neurons.addAll(leftLayer);
        neurons.addAll(rightLayer);

        return neurons;
    }


    /**
     * Gets the connections
     *
     * @return List of Lists representing the connections betweeen neurons
     */
    public List<List<Connection>> getConnections() {
        return connections;
    }




    // Utility


    /**
     * Utility to create a specified number of Neurons
     *
     * @param neuronCount number of Neurons to create
     * @return List of created Neurons
     */
    public static List<Neuron> createNeurons(int neuronCount) {
        List<Neuron> layer = new ArrayList<>();

        for (; neuronCount>0; neuronCount--) {
            layer.add(new Neuron());
        }

        System.out.println("neuron: ok");
        return layer;
    }

    /**
     * Utility to create Neurons based on input values
     *
     * @param values List of values to be assigned to created Neurons
     * @return List of created Neurons
     */
    public static List<Neuron> createNeurons(List<Double> values) {
        int neuronCount = values.size();
        List<Neuron> layer = new ArrayList<>();

        for (Double value : values) {
            layer.add(new Neuron(value));
        }

        return layer;
    }

    /**
     * Process values through all neurons
     */
    public List<Double> processActivations() {
        this.connections = f_propagate();

        List<Double> final_values = new ArrayList<>();

        for (Neuron neuron : getOutputLayer()) {
            List<Double> values = connections.stream()
                    .filter(list -> !list.isEmpty())
                    .map(List::getFirst) // flatten the list of lists into a single stream
                    .map(connection -> connection.getInputNeuron().getValue())
                    .collect(Collectors.toList());

            final_values.add(neuron.activation(values));
        }

        return final_values;
    }
    public void processActivationsVoid(ConnectionBlock... extra) {
        this.connections = f_propagate();

        for (Neuron neuron : getOutputLayer()) {
            List<Double> values = connections.stream()
                    .filter(list -> !list.isEmpty())
                    .map(List::getFirst) // flatten the list of lists into a single stream
                    .map(connection -> connection.getInputNeuron().getValue())
                    .collect(Collectors.toList());

            neuron.activation(values);
        }

        for (ConnectionBlock block : extra) {
            block.processActivationsVoid();
        }
    }

    /**
     * Utility to connect Neurons in two layers
     *
     * @param leftLayer List of Neurons to be connected from
     * @param rightLayer List of Neurons to be connected to
     * @return List of Lists representing the connections
     */
    public static List<List<Connection>> createConnections(List<Neuron> leftLayer, List<Neuron> rightLayer) {
        List<List<Connection>> connections = new ArrayList<>();

        for (int j = 0; j < leftLayer.size(); j++) {
            connections.add(new ArrayList<>());

            for (Neuron r_neuron : rightLayer) {
                connections.get(j).add(new Connection(leftLayer.get(j), r_neuron));

                System.out.printf("new %4.4s %4.4s connection: done\n", leftLayer.get(j), r_neuron);
            }

        }

        return connections;
    }

    /**
     * Method to propagate values through all connections of the current ConnectionBlock
     *
     * @return Updated List of Lists representing the connections of the current ConnectionBlock
     */
    private List<List<Connection>> f_propagate() {
        return ForwardPropagate.propagate(this.connections);
    }
}