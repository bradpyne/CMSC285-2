package main;

public class Commuter {

    private final double arrivalTime; // time this commuter group enters the system
    private double totalWait; // total minutes spent waiting
    private double totalTravel; // total minutes spent riding (taxi + train)

    private final String startLocation; // origin node
    private final String destination;// destination node

    private final int groupSize; // how many real people this object represents

    public Commuter(double arrivalTime, String startLocation, String destination, int groupSize) {
        this.arrivalTime = arrivalTime;
        this.startLocation = startLocation;
        this.destination = destination;
        this.groupSize = groupSize;
    }

    public double getArrivalTime() { return arrivalTime; }
    public String getStartLocation() { return startLocation; }
    public String getDestination() { return destination; }
    public int getGroupSize() { return groupSize; }

    public double getTotalWait() { return totalWait; }
    public double getTotalTravel() { return totalTravel; }

    public void addWait(double dt) { totalWait += dt; }
    public void addTravel(double dt) { totalTravel += dt; }

    public double getElapsed() {
        return totalWait + totalTravel;
    }
}