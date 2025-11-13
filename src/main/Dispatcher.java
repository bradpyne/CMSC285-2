package main;

public class Dispatcher {
    Stack<RoboTaxi> taxiFleet = new Stack<RoboTaxi>();
    //  data structure for taxis actively in service - held by route? all together? - linked list?

    int taxiCount;
    int taxiSeats;

    public Dispatcher( int numTaxi, int numTaxiSeats ) {
        taxiCount = numTaxi;
        taxiSeats = numTaxiSeats;
        for( int i = 0; i < numTaxi; i++ ) {
            taxiFleet.push( new RoboTaxi( (i + 1),  numTaxiSeats ) );
        }
        //create given number of RoboTaxi objects
    }

    public char checkRoute ( int locID ) {
        if ( locID < 100 ) {
            return 'a';
        } else if ( locID < 200 ) {
            return 'b';
        } else if( locID < 300 ) {
            return 'c';
        } else if( locID < 400 ) {
            return 'd';
        } else if( locID < 500 ) {
            return 'e';
        } else if( locID < 600 ) {
            return 'f';
        }
        else return 'z';
    }

    public void callTaxi ( int locID, Commuter commuter ) {
        char route = checkRoute( locID );
        if( route == 'z' ) {
            System.out.println("Invalid locID, no route found");
        } else {}
        // check robotaxi fleet for robotaxi on same route;
        // if robotaxi location is > locID && not full
        // assign commuter to taxi
        // else if taxi stack not empty, pop taxi from stack and startRoute( route, locID )
        // assign commuter to taxi
        // else (temp)
    }

    public void returnToOrigin( RoboTaxi taxi ) {
        int numPassengers = taxiSeats - taxi.getOpenSeats();
        taxiFleet.push( taxi );
    }
}
