package main;

public class Job {
    public double enterTime;
    public double startTime;
    public double serviceTime;
    public double endTime;
    public double finishedTime;
    Customer customer;

    public Job ( double currentTime, Customer c ) {
        enterTime = currentTime;
        customer = c;
    }
}
