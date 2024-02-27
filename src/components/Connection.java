package components;

import java.util.Random;

/**
 * Represents a connection in a neural network. This class holds the connections between neurons
 * along with the associated weight and value.
 */
public class Connection {
    private double value;
    private double weight;
    private final Neuron INPUT_NEURON;
    private final Neuron OUTPUT_NEURON;

    /**
     * Initialize Connection with input neuron and output neuron.
     * Initial value is set to 0 while weight is assigned a random value.
     *
     * @param input_neuron  The input neuron of this connection
     * @param output_neuron The output neuron of this connection
     */
    public Connection(Neuron input_neuron, Neuron output_neuron) {
        this.INPUT_NEURON = input_neuron;
        this.OUTPUT_NEURON = output_neuron;

        this.weight = new Random().nextDouble();
    }

    /**
     * Initialize Connection with input neuron, output neuron and weight.
     *
     * @param input_neuron  The input neuron of this connection
     * @param output_neuron The output neuron of this connection
     * @param weight        The weight of this connection
     */
    public Connection(Neuron input_neuron, Neuron output_neuron, double weight) {
        this.INPUT_NEURON = input_neuron;
        this.OUTPUT_NEURON = output_neuron;

        this.weight = weight;
    }


    // Getters
    public double getValue() {
        return value;
    }

    /**
     * Get the weight associated with this Connection.
     *
     * @return The weight of this Connection
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Get the input neuron of this Connection.
     *
     * @return The input neuron of this Connection
     */
    public Neuron get_Input_Neuron() {
        return INPUT_NEURON;
    }

    /**
     * Get the output neuron of this Connection.
     *
     * @return The output neuron of this Connection
     */
    public Neuron get_Output_Neuron() {
        return OUTPUT_NEURON;
    }


    /**
     * Set the value of this Connection.
     *
     * @param value The new value of this Connection
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Set the weight of this Connection.
     *
     * @param weight The new weight of this Connection
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }


    // Utility

    /**
     * Utility function to calculate the weighted value of this Connection.
     *
     * @return The product of the value and the weight of this Connection
     */
    public double weight() {
        this.value = INPUT_NEURON.get_Value() * weight;
        System.out.printf("\n\nIMPORTANT: %f\n\n", this.value);
        return this.value;
    }

}
