package interfaces;

import java.util.List;

public interface ProtoNeuron {
    /**
     * Method to process and return components.Neuron output
     * @return double
     */
    double activation(List<Double> input_values);
}
