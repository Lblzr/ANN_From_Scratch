package SHO;
// List Operations Helper

import java.util.List;

public class LO {
    /**
     * Method to sum the inputted weights
     * @param input_list List-Interface-based object of neuron inputs/values
     * @return double
     */
    public static double sumConnections(List<Double> input_list) {
        return input_list.stream()
                         .reduce(0d, Double::sum);
    }

    public static double highestValueLocation(List<Double> list) {
        double out = 0d;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > out) {
                out = i;

            }
        }

        return out;
    }
}
