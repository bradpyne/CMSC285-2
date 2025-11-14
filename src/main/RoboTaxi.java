package main;

public class RoboTaxi {
    int vin;
    int state; // 0 idle, 1 dispatching, 2 in transit
    int route;
    int capacity;
    int openSeats;
    int currentLocation;
    int nextLocation;
    Commuter[] passengers;


    public RoboTaxi(int id, int numTaxiSeats) {
        vin = id;
        capacity = numTaxiSeats;
        openSeats = capacity;
        currentLocation = 0; // STATION
        state = 0; // idle
        passengers = new Commuter[ capacity ];
    }

    public void startRoute ( int rt, int locID ) {
        route = rt;
        nextLocation = locID;
    }

    public int getVin() {
        return vin;
    }

    public int getRoute() {
        return route;
    }

    public int getLocation() {
        return currentLocation;
    }

    public int getOpenSeats() {
        return openSeats;
    }

    public void pickupCommuter ( int locID, Commuter commuter) {
        if ( openSeats > 0 ) {
            passengers[capacity - openSeats] = commuter;
            openSeats--;
        }
    }
}