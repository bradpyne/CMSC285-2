import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Transit {
    private final String id;
    private final TrainDirection direction;
    private final int capacity;
    private final List<Double> departureTimes;
    private final double transitTime;

    private int tripsCompleted;
    private int totalPassengers;

    public Transit(String id, TrainDirection direction, int capacity,
            List<Double> departureTimes, double transitTime) {
        this.id = id;
        this.direction = direction;
        this.capacity = capacity;
        this.departureTimes = new ArrayList<>(departureTimes);
        this.transitTime = transitTime;
        this.tripsCompleted = 0;
        this.totalPassengers = 0;
    }

    public List<Commuter> board(Queue<Commuter> waitingQueue, double now) {
        List<Commuter> boarded = new ArrayList<>();
        while (!waitingQueue.isEmpty() && boarded.size() < capacity) {
            Commuter c = waitingQueue.poll();
            c.setState(CommuterState.ON_TRAIN);
            c.markJourneyStart(now);
            boarded.add(c);
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

    public TrainDirection getDirection() {
        return direction;
    }

    public String getId() {
        return id;
    }
}
