
public class Job {
    public double enterTime;
    public double startTime;
    public double serviceTime;
    public double endTime;
    public double finishedTime;
    Commuter commuter;

    public Job(double currentTime, Commuter c) {
        enterTime = currentTime;
        commuter = c;
    }
}
