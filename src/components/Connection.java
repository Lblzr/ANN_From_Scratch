package components;

public class Connection {
    double value;
    double weight;
    Neuron input_neuron;
    Neuron output_neuron;

    public Connection(Neuron input_neuron, Neuron output_neuron) {
        this.input_neuron = input_neuron;
        this.output_neuron = output_neuron;

        this.value = 0;
        this.weight = 0;
    }
    public Connection(Neuron input_neuron, Neuron output_neuron, double weight) {
        this.input_neuron = input_neuron;
        this.output_neuron = output_neuron;

        this.weight = weight;
    }


    // Getters
    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

}
