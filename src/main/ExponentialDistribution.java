package main;

/**
 * Exponential(λ) distribution.
 * Good model for interarrival times (memoryless).
 */
public class ExponentialDistribution extends RandomDistribution {
    private final double lambda;

    public ExponentialDistribution(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public double sample() {
        double u = rng.nextDouble();   // random number in [0,1)
        return -Math.log(1.0 - u) / lambda;
    }
}