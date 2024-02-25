package components;

import interfaces.INeuron;
import java.util.List;
import java.util.ArrayList;

public class ConnectionBlock {
    private final List<Neuron> leftLayer;
    private final List<Neuron> rightLayer;
    private final List<Connection> connections;

    public ConnectionBlock(List<Neuron> inputs, int neuronCount) {
        this.leftLayer = new ArrayList<>(inputs);
        this.rightLayer = createNeurons(neuronCount);
        connections = createConnections(this.leftLayer, this.rightLayer);
    }
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

    public List<Neuron> return_Neurons() {
        List<Neuron> neurons = new ArrayList<>();
        neurons.addAll(leftLayer);
        neurons.addAll(rightLayer);

        return neurons;
    }


    // Utility
    public List<Neuron> createNeurons(int neuronCount) {
        List<Neuron> layer = new ArrayList<>();
        for (; neuronCount>0; neuronCount--) {
            layer.add(new Neuron());
        }

        return layer;
    }

    public List<Connection> createConnections(List<Neuron> leftLayer, List<Neuron> rightLayer) {
        List<Connection> connections = new ArrayList<>();

        for (Neuron neuron : leftLayer) {
            for (Neuron neuron2 : rightLayer) {
                connections.add(new Connection(neuron, neuron2));
            }
        }

        return connections;
    }

}
