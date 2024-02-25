package components;

import java.util.List;
//import java.util.ArrayList;
import java.util.Random;
import interfaces.INeuron;
import operations.NN;

public class Neuron implements INeuron {
    private double bias;

    public Neuron() {
        this.bias = new Random().nextDouble();
    }
    public Neuron(double bias) {
        this.bias = bias;
    }

    //region Super
    @Override
    public double get_Bias() {
        return bias;
    }

    @Override
    public void setBias(double value) {
        this.bias = value;
    }

    @Override
    public void adjustBias(double value) {
        bias+=value;
    }

    @Override
    public List<INeuron> get_Connections() {
        return null;
    }

    @Override
    public double sum_Connections(List<Double> input_values) {
        return input_values.stream()
                           .reduce(0d, Double::sum);
    }

    @Override
    public double process_Output(List<Double> input_values) {
        return operations.NN.sigmoid(sum_Connections(input_values))+bias;
    }
    //endregion

}
