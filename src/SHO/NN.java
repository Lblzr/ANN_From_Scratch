package SHO;
// Neural Network Helper

public class NN {
    public static double default_alpha = 0.01;


    public static double sigmoid(double input) {
        return 1d/(1d+Math.exp(-input));
    } // f(x) = 1/(1+e^-x)

    public static double ReLU(double input) {
        return Math.max(0d, input);
    } // f(x) = max(x, 0)

    public static double LReLU(double input) {
        return Math.max(input * default_alpha, input);
    }

    public static double LReLU(double input, double alpha) {
        return PReLU(input, alpha );
    }

    public static double PReLU(double input, double alpha) {
        return Math.max(input * alpha, input);
    }

    public static double PELU(double input, double alpha) {
        return input <= 0 ? alpha*(Math.exp((1/alpha)*input)-1) : input;
    }
}

