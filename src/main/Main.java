package main;

import components.ConnectionBlock;
import components.Neuron;

import java.util.List;
import java.util.ArrayList;

public class Main {
//    private Scanner scanner; // create scanner (deprecated for now until reason for scanner is found)

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        List<Double> input_values = new ArrayList<>();
        for (int i = 32*32; i>0; i--) {
            input_values.add(Math.random());
        }

        List<Neuron> input_neurons = ConnectionBlock.create_Neurons(input_values);

        ConnectionBlock input_l1 = new ConnectionBlock(input_neurons, 8),
                l1_l2 = new ConnectionBlock(input_l1.get_Output_Layer(), 8),
                l2_l3 = new ConnectionBlock(l1_l2.get_Output_Layer(), 8),
                l3_output = new ConnectionBlock(l2_l3.get_Output_Layer(), 10);

        input_l1.processNeurons();
        l1_l2.processNeurons();
        l2_l3.processNeurons();
        l3_output.processNeurons();

    }
}
