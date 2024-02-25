package components;

import java.util.List;
import java.util.ArrayList;

public class ConnectionBlock {
    private final List<Neuron> leftLayer;
    private final List<Neuron> rightLayer;

    public ConnectionBlock(List<Neuron> inputs, int neuronCount) {
        this.leftLayer = new ArrayList<>(inputs);
        this.rightLayer = createNeurons(neuronCount);
    }
    public ConnectionBlock(List<Neuron> inputs, List<Neuron> outputs) {
        this.leftLayer = new ArrayList<>(inputs);
        this.rightLayer = new ArrayList<>(outputs);
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

}
