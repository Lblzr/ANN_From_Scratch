package components;

import java.util.List;
import java.util.Random;
import interfaces.INeuron;

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
        // Old: this.bias = new Random().nextDouble();
        System.out.printf("A Neuron is created with random bias value: %f\n", this.bias); // TODO: remove
    }

    /**
     * Constructs a new neuron with a specified bias value.
     *
     * @param value The bias value for the neuron.
     */
    public Neuron(double value) {
        this.value = value;
        this.bias = new Random().nextDouble();
        // Old: this.bias = bias
        System.out.printf("A Neuron is created with given value: %f\n", this.value); // TODO: remove
        System.out.printf("A Neuron is created with random bias value: %f\n", this.bias); // TODO: remove
    }


    //region Super
    // Getters

    /**
     * {@inheritDoc}
     */
    @Override
    public double get_Bias() {
        // Old: return bias;
        System.out.printf("get_Bias is called. The bias returned is: %f\n", this.bias); // TODO: remove
        return bias;
    }

    public double get_Value() {
        // Old: return value;
        System.out.printf("get_Value is called. The bias returned is: %f\n", this.bias); // TODO: remove
        return value;
    }


    // Setters

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBias(double value) {
        // Old: this.bias = value;
        this.bias = value;
        System.out.printf("setBias method is called. The updated bias value is: %f\n", this.bias); // TODO: remove
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void adjustBias(double value) {
        bias += value;
        // Old: bias += value;
        System.out.printf("adjusted bias. The updated bias value is: %f\n", this.bias); // TODO: remove
    }


    // Utility

    /**
     * {@inheritDoc}
     */
    @Override
    public double sum_Connections(List<Double> input_values) {
        double sum = input_values.stream()
                    .reduce(0d, Double::sum);
        // Old: return input_values.stream().reduce(0d, Double::sum);
        System.out.printf("sum_Connections method calculated sum of connections: %f\n", sum); // TODO: remove

        return sum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double process_Activation(List<Double> input_values) {
        double output = SHO.NN.sigmoid(sum_Connections(input_values)) + bias;
        // Old: return SHO.NN.sigmoid(sum_Connections(input_values)) + bias;
        System.out.printf("process_Activation method calculated output: %f\n", output); // TODO: remove

        this.value = output;
        return output;
    }
    //endregion
}