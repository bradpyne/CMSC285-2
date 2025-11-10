package main;

/** One leg of travel processed by a service (robotaxi or train). */
public class Trip {

    public enum Mode { ROBOTAXI, TRAIN }

    // Times used by queue/scheduler; same idea as the old Job
    public double enterTime;    // when commuter asks for this leg
    public double startTime;    // when the vehicle actually departs
    public double serviceTime;  // in-vehicle time for this leg
    public double endTime;      // startTime + serviceTime
    public double finishedTime; // when the leg is marked done (if you need it)

    // Domain data
    public final Commuter commuter;
    public final String fromNode;
    public final String toNode;
    public final Mode mode;

    public Trip(double currentTime, Commuter commuter, String fromNode, String toNode, Mode mode) {
        this.enterTime = currentTime;
        this.commuter  = commuter;
        this.fromNode  = fromNode;
        this.toNode    = toNode;
        this.mode      = mode;
    }
}
