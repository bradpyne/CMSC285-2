package main;


public class Commuter {
    double arrivalTime;
    boolean inTransit = false;
    int startPos;
    int endPos;

    public Customer(double time) {
        arrivalTime = time;
    }

    public Object getArrivalTime() {
        return arrivalTime;
    }

}
