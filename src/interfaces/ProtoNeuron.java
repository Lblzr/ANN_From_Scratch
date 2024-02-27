package interfaces;

import java.util.List;

public interface ProtoNeuron {
    /**
     * Method to sum the inputted weights
     * @param input_values
     * @return double
     */
    double sum_Connections(List<Double> input_values);

    /**
     * Method to process and return components.Neuron output
     * @return double
     */
    double process_Activation(List<Double> input_values);
}
