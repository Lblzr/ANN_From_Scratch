package components;

import java.util.List;
import java.util.Random;

import interfaces.INeuron;

import SHO.NN;
import SHO.LO;

/**
 * Represents a single neuron in a neural network.
 */
public class Neuron implements INeuron {
    private double bias;
    private double value;

    /**
     * Constructs a new neuron with a randomly generated bias value.
     */
    public Neuron() {
        this.bias = new Random().nextDouble();
    }

    /**
     * Constructs a new neuron with a specified bias value.
     *
     * @param value The bias value for the neuron.
     */
    public Neuron(double value) {
        this.value = value;
        this.bias = new Random().nextDouble();
    }


    //region Super
    // Getters

    /**
     * {@inheritDoc}
     */
    @Override
    public double getBias() {
        return bias;
    }

    public double getValue() {
        return value;
    }


    // Setters

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBias(double value) {
        this.bias = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void adjustBias(double value) {
        bias += value;
    }


    // Utility

    /**
     * {@inheritDoc}
     */
    @Override
    public double activation(List<Double> input_values) {
        double output = NN.PELU(LO.sumConnections(input_values) + bias, 0.5d);

        this.value = output;
        return output;
    }
    //endregion
}