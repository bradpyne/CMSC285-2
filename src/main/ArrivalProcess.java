package main;

import java.util.Random;

public class ArrivalProcess {
    private final ExponentialDistribution interArrivalDist;
    private double nextArrivalTime;
    private final Random rng;

    // These define where this stream of commuters is coming from / going to
    private final int startNode;
    private final int destinationNode;

    // Group size range (how many real people per Commuter)
    private final int minGroupSize;
    private final int maxGroupSize;


    public ArrivalProcess(double startTime, 
                          double lambda, 
                          Random rng, 
                          int startNode, 
                          int destinationNode, 
                          int minGroupSize, 
                          int maxGroupSize){

        this.interArrivalDist = new ExponentialDistribution(lambda);
        this.rng = rng;
        this.startNode = startNode;
        this.destinationNode = destinationNode;
        this.minGroupSize = minGroupSize;
        this.maxGroupSize = maxGroupSize;
        this.nextArrivalTime = startTime + interArrivalDist.sample();
    }

    public double getNextArrivalTime() {
        return nextArrivalTime;
    }

    public Commuter nextCommuter(double currentTime) {
        // Pick a random group size in [minGroupSize, maxGroupSize]
        int groupSize = minGroupSize +
                rng.nextInt(maxGroupSize - minGroupSize + 1);
        
        Commuter c = new Commuter(nextArrivalTime, startNode, destinationNode, groupSize);

        nextArrivalTime += interArrivalDist.sample();
        return c;
    }
}
