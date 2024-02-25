package components;

public class Connection {
    double value;
    double weight;
    NeuronOLD neuron_output;
    NeuronOLD neuron_input;

    public Connection(NeuronOLD neuron_output, NeuronOLD neuron_input) {
        this.neuron_output = neuron_output;
        this.neuron_input = neuron_input;

        this.value = 0;
        this.weight = 0;
    } // end of Constructor
    public Connection(NeuronOLD neuron_output, NeuronOLD neuron_input, double value, double weight) {
        this.neuron_output = neuron_output;
        this.neuron_input = neuron_input;

        this.value = value;
        this.weight = weight;
    } // end of Constructor


    // Getters
    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

} // end of components.Connection
