package operations;

public class NN {
    public static double sigmoid(double input) {
        return 1d/(1d+Math.exp(-input));
    } // 1/(1+e^-x)
}

