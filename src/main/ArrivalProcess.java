package main;

import java.util.Random;

/** Poisson-like arrival stream for commuters at a pickup point. */
public class ArrivalProcess {
    private final RandomDistribution interArrival;
    private double nextArrivalTime;

    public ArrivalProcess(Random rng, double startTime, double ratePerMinute) {
        // default: exponential inter-arrival with given rate
        this.interArrival = new ExponentialDistribution(rng, ratePerMinute);
        this.nextArrivalTime = startTime;
    }

    /** Time of next commuter arrival. */
    public double peekNextTime() { return nextArrivalTime; }

    /** Create the next commuter and advance the clock. */
    public Commuter nextCommuter() {
        Commuter c = new Commuter(nextArrivalTime);
        nextArrivalTime += interArrival.sample();
        return c;
    }
}
