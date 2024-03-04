package interfaces;

public interface INeuron extends ProtoNeuron {
//    List<interfaces.INeuron> get_Connections();

    /**
     * Getter to return bias value
     * @return double
     */
    double getBias();

    /**
     * Setter to set bias value
     * @param value
     */
    void setBias(double value);

    /**
     * Method to adjust Bias by value
     * @param value
     */
    void adjustBias(double value);

//    double sum_Connections(List<double> input_values);
//    double calculate_Output();
}
