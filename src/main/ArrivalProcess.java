package main;

import java.util.Random;

public class ArrivalProcess {
    private final ExponentialDistribution interArrivalDist;
    private double nextArrivalTime;
    private final Random rng;

    public ArrivalProcess(double startTime, double lambda, Random rng) {
        this.interArrivalDist = new ExponentialDistribution(lambda);
        this.rng = rng;
        this.nextArrivalTime = startTime + interArrivalDist.sample();
    }

    public double getNextArrivalTime() {
        return nextArrivalTime;
    }

    public Commuter nextJob(double currentTime) {
        Commuter c = new Commuter(nextArrivalTime);
        nextArrivalTime += interArrivalDist.sample();
        return c;
    }
}
