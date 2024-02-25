package components;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import interfaces.INeuron;

public class Neuron implements INeuron {
    private List<Double> input_values;
    private double bias;
    private List<INeuron> connections = new ArrayList<>();

    public Neuron() {
        this.bias = new Random().nextDouble();
        ConnectionBlock.neurons.add(this);
    }
    public Neuron(double bias) {
        this.bias = bias;
        ConnectionBlock.neurons.add(this);
    }

    //

    //region Super
    @Override
    public double get_Bias() {
        return 0;
    }

    @Override
    public void setBias(double value) {

    }

    @Override
    public void adjustBias(double value) {

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
    public double process_Output() {
        return sum_Connections(input_values);
    }
//endregion

}
