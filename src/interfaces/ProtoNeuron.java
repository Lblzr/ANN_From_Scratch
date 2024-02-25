package interfaces;

import java.util.List;

public interface ProtoNeuron {
    /**
     * Method to get connections to current components.Neuron instance
     * @return List<interfaces.INeuron>
     */
    List<INeuron> get_Connections();

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
    double process_Output(List<Double> input_values);
}
