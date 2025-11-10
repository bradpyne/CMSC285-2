package main;

/** Single-server FIFO queue processing Trips; updates commuter QoIs. */
public class SingleServerQueue {
    private final Queue<Trip> q = new Queue<>();
    private final RandomDistribution serviceTimeDistribution;

    private Trip inService;

    public SingleServerQueue(RandomDistribution dist) {
        if (dist == null) throw new IllegalArgumentException("dist required");
        this.serviceTimeDistribution = dist;
    }

    /** Arrive a trip at time 'now'. */
    public void add(Trip trip, double now) {
        if (trip.enterTime == 0) trip.enterTime = now;
        trip.serviceTime = Math.max(0, serviceTimeDistribution.sample());

        if (inService == null) {
            // start immediately
            inService = trip;
            inService.startTime = now;
            inService.endTime   = now + inService.serviceTime;

            // QoIs: wait = start - enter
            double wait = inService.startTime - inService.enterTime;
            if (wait > 0) inService.commuter.addWait(wait);
        } else {
            q.enqueue(trip);
        }
    }

    /** Next completion time; Double.MAX_VALUE if idle. */
    public double getEndServiceTime() {
        return (inService != null) ? inService.endTime : Double.MAX_VALUE;
    }

    /** Complete current trip at 'now', start next if any, and return completed trip. */
    public Trip complete(double now) {
        if (inService == null) return null;

        inService.finishedTime = now;

        // QoIs: add travel when it actually completes
        inService.commuter.addTravel(inService.serviceTime);
        if (inService.mode == Trip.Mode.ROBOTAXI) inService.commuter.markTaxi();
        if (inService.mode == Trip.Mode.TRAIN)    inService.commuter.markTrain();

        Trip done = inService;

        if (q.isEmpty()) {
            inService = null;
        } else {
            inService = q.dequeue();
            inService.startTime = now;
            inService.endTime   = now + inService.serviceTime;

            // QoIs for the next one’s wait
            double wait = inService.startTime - inService.enterTime;
            if (wait > 0) inService.commuter.addWait(wait);
        }
        return done;
    }

}
