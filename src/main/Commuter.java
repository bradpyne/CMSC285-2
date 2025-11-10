package main;


public class Commuter {
    private final double arrivalTime;         // when they first enter the system
    private double totalWait, totalTravel;    // accumulated minutes
    private boolean usedTaxi, usedTrain;      // mode usage flags

    public Commuter(double arrivalTime) { this.arrivalTime = arrivalTime; }

    public double getArrivalTime() { return arrivalTime; }
    public void addWait(double dt)   { totalWait  += dt; }
    public void addTravel(double dt) { totalTravel += dt; }
    public void markTaxi()  { usedTaxi  = true; }
    public void markTrain() { usedTrain = true; }

    public double getTotalWait()   { return totalWait; }
    public double getTotalTravel() { return totalTravel; }
    public double getElapsed()     { return totalWait + totalTravel; } // wait + in-vehicle
    public boolean usedTaxi()  { return usedTaxi; }
    public boolean usedTrain() { return usedTrain; }
}
