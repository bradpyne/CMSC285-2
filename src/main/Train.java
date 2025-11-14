import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Train {
    private final String id;
    private final String origin = "Frederick";
    private final String destination = "DC";
    private final int fixedCapacity = 10;
    private final List<Double> departureTimes;
    private final double transitTime;

    private int tripsCompleted;
    private int totalPassengers;

    public Train(String id, List<Double> departureTimes, double transitTime) {
        this.id = id;
        this.departureTimes = new ArrayList<>(departureTimes);
        this.transitTime = transitTime;
        this.tripsCompleted = 0;
        this.totalPassengers = 0;
    }

    public List<Commuter> board(Queue<Commuter> waitingQueue, double now) {
        List<Commuter> boarded = new ArrayList<>();
        int count = 0;
        while (!waitingQueue.isEmpty() && count < fixedCapacity) {
            Commuter c = waitingQueue.poll();
            c.setState(CommuterState.ON_TRAIN);
            c.markJourneyStart(now);
            boarded.add(c);
            count++;
        }
        totalPassengers += boarded.size();
        tripsCompleted++;
        return boarded;
    }

    public void disembark(List<Commuter> onboard, double now) {
        for (Commuter c : onboard) {
            c.setState(CommuterState.COMPLETED);
            c.markJourneyEnd(now);
        }
        onboard.clear();
    }

    public String getRoute() {
        return origin + " to " + destination;
    }

    public double getTransitTime() {
        return transitTime;
    }

    public int getTripsCompleted() {
        return tripsCompleted;
    }

    public double getAveragePassengersPerTrip() {
        return tripsCompleted == 0 ? 0 : (double) totalPassengers / tripsCompleted;
    }

    public List<Double> getDepartureTimes() {
        return departureTimes;
    }

    public String getId() {
        return id;
    }
}
