package main;

import components.ConnectionBlock;
import components.Neuron;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.*;


import SHO.LO;

public class Main {
//    private Scanner scanner; // create scanner (deprecated for now until reason for scanner is found)

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        List<Double> outputs;
        int output;

        List<Double> input_values = new ArrayList<>();
        for (int i = 32*32; i>0; i--) input_values.add((double)new Random().nextInt(0, 255));

        List<Neuron> input_neurons = ConnectionBlock.createNeurons(input_values);

        ConnectionBlock input_l1 = new ConnectionBlock(input_neurons, 8),
                l1_l2 = new ConnectionBlock(input_l1.getOutputLayer(), 8),
                l2_l3 = new ConnectionBlock(l1_l2.getOutputLayer(), 8),
                l3_output = new ConnectionBlock(l2_l3.getOutputLayer(), 10);

        input_l1.processActivationsVoid(l1_l2, l2_l3);
        System.out.printf("\n\nOutput: %s\n\n", l3_output.processActivations());

        for (Neuron list : l3_output.getOutputLayer()) {
            System.out.printf(" %s, ", list.getValue());
        }
        output = (int) LO.highestValueLocation(
                l3_output.getOutputLayer()
                             .stream         ()
                             .map            (Neuron::getValue)
                             .collect        (Collectors.toList())
                             );

        System.out.printf("\n\nResult: %s", l3_output.getOutputLayer()
                                                     .get(output)
                                                     .getValue());

    }


    public static List<ConnectionBlock> createBlocks(boolean inclusive, List<Double> input_values, int... m_layers) { // minimum 3 layers, so m_layers specifies the middle layer count, not counting inp/out
        throw new UnsupportedOperationException("createBlocks is not yet implemented!");
    }

}
