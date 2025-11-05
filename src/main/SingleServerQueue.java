package main;

public class SingleServerQueue {
    private Queue<Job> jobs;
    private Job jobInService;
    RandomDistribution serviceTimeDistribution;

    public SingleServerQueue() {
        jobs = new Queue<Job>();
    }

    void add( Job newJob, double currentTime ) {
        double serviceTime = serviceTimeDistribution.sample();
        newJob.serviceTime = serviceTime;
        if( jobInService == null ) {
            jobInService = newJob;
            jobInService.startTime = currentTime;
            jobInService.endTime = (currentTime + serviceTime);
        } else {
            jobs.enqueue( newJob );
        }
    }

    double getEndServiceTime() {
        if( jobInService != null ) {
            return jobInService.endTime;
        } else {
            return Double.MAX_VALUE;
        }
    }

    Job complete( double currentTime ) {
        jobInService.finishedTime = currentTime;
        Job completedJob = jobInService;
        if ( jobs.isEmpty() ) {
            jobInService = null;
        } else {
            jobInService = jobs.dequeue();
            jobInService.startTime = currentTime;
            jobInService.endTime = (currentTime + jobInService.serviceTime);
        }
        return completedJob;
    }

}
