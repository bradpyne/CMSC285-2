package main;

public class NormalDistribution extends RandomDistribution {
    private final double mean;     // Center of the bell curve
    private final double stddev;   // Spread (how wide the curve is)

    public NormalDistribution(double mean, double stddev) {
        this.mean = mean;
        this.stddev = stddev;
    }

    @Override
    public double sample() {
        // rng.nextGaussian() generates a random value from a "standard normal distribution":
        //   - mean = 0
        //   - standard deviation = 1
        //
        // The "Gaussian" distribution is just another name for the "Normal" distribution.
        // To convert it to our desired mean and stddev:
        //   X = mean + stddev * Z
        // where Z is the standard normal value.
        double z = rng.nextGaussian();
        return mean + stddev * z;
    }

}