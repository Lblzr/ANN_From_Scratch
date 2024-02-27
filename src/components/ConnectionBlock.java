package components;

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
     * @param inputs List of input Neurons for this block
     * @param neuron_count number of Neurons to be created for the output layer
     */
    public ConnectionBlock(List<Neuron> inputs, int neuron_count) {
//        this.neuron_count = neuron_count;

        this.leftLayer = new ArrayList<>(inputs);
        this.rightLayer = create_Neurons(neuron_count);

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

    public List<Neuron> get_Input_Layer() {
        return leftLayer;
    }

    public List<Neuron> get_Output_Layer() {
        return rightLayer;
    }

    /**
     * Returns all the neurons in this block
     *
     * @return List of all Neurons in this block
     */
    public List<Neuron> return_Neurons() {
        List<Neuron> neurons = new ArrayList<>();
        neurons.addAll(leftLayer);
        neurons.addAll(rightLayer);

        return neurons;
    }

    /**
     * Returns the output layer of this block
     *
     * @return List of Neurons present in the output layer
     */
    public List<Neuron> return_Output() {
        System.out.print("return_Output method is called. Returning output layer neurons\n"); // TODO: remove
        return rightLayer;
    }

    /**
     * Gets the connections
     *
     * @return List of Lists representing the connections betweeen neurons
     */
    public List<List<Connection>> getConnections() {
        System.out.print("getConnections method is called. Returning all connections\n"); // TODO: remove
        return connections;
    }




    // Utility


    /**
     * Utility to create a specified number of Neurons
     *
     * @param neuronCount number of Neurons to create
     * @return List of created Neurons
     */
    public static List<Neuron> create_Neurons(int neuronCount) {
        System.out.printf("createNeurons method is called. Creating %d neurons\n", neuronCount); // TODO: remove
        List<Neuron> layer = new ArrayList<>();

        for (; neuronCount>0; neuronCount--) {
            layer.add(new Neuron());
            System.out.printf("Neuron: %s Added\n", layer.getLast()); // TODO: remove
        }

        return layer;
    }

    /**
     * Utility to create Neurons based on input values
     *
     * @param values List of values to be assigned to created Neurons
     * @return List of created Neurons
     */
    public static List<Neuron> create_Neurons(List<Double> values) {
        System.out.print("createNeurons method is called with list of values parameter.\n"); // TODO: remove
        int neuronCount = values.size();
        List<Neuron> layer = new ArrayList<>();

        for (Double value : values) {
            layer.add(new Neuron(value));
            System.out.printf("Neuron: %s Added\n", layer.getLast()); // TODO: remove
        }

        return layer;
    }

    /**
     * Process values through all neurons
     */
    public void processNeurons() {
        this.connections = propagate();

        for (Neuron neuron : return_Output()) {

            List<Double> values = connections.stream()
                    .filter(list -> !list.isEmpty())
                    .map(List::getFirst) // flatten the list of lists into a single stream
                    .map(connection -> connection.get_Input_Neuron().get_Value())
                    .collect(Collectors.toList());

            neuron.process_Activation(values);
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
        System.out.print("createConnections method is called\n"); // TODO: remove
        List<List<Connection>> connections = new ArrayList<>();

        for (int j = 0; j < leftLayer.size(); j++) {
            connections.add(new ArrayList<>());
            for (int i = 0; i < rightLayer.size(); i++) {
                connections.get(j).add(new Connection(leftLayer.get(j), rightLayer.get(i)));
                System.out.printf("j; %d i; %d Connection: %s Added\n", j, i, connections.get(j).get(connections.get(j).size() - 1)); // TODO: remove

            }

        }

        return connections;
    }

    /**
     * Method to propagate values through all connections
     *
     * @param connections List of lists representing the connections
     * @return Updated List of Lists representing the connections
     */
    public List<List<Connection>> propagate(List<List<Connection>> connections) {
        System.out.println("propagate method is called"); // TODO: remove
        for (int i = 0; i < connections.size(); i++) {
            List<Connection> list = connections.get(i);
            list.forEach(connection -> {
                double tempCon = connection.weight();
                connection.setValue(tempCon);
                System.out.printf("Connection weight applied: %s, %s\n", connection.getValue(), tempCon); // TODO: remove
            });
        }

        return connections;
    }

    /**
     * Method to propagate values through all connections of the current ConnectionBlock
     *
     * @return Updated List of Lists representing the connections of the current ConnectionBlock
     */
    private List<List<Connection>> propagate() {
        return propagate(this.connections);
    }
}