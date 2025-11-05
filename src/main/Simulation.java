package main;

/*
 This will have the following:
        ● One or more main.SingleServerQueue objects
        ● A double type variable (“currentTime”) to represent the current time (initially 0).
        ● A public method run( double sim_time ) to run the simulation. The parameter
            sim_time is the length of time we wish to run for.
        ● An main.main.ArrivalProcess object for arrival times.
        ● A separate Queue structure to hold completed jobs. It is necessary to hold on to
            these for processing at the end of the simulation.

The run() method will start with the arrival of a first job, which can go into service in the queue
(thus generating a service time). The doLoop method will then generate an arrival time to
determine when the next arrival occurs. The doLoop method will also maintain the current
time, which starts at zero.

Your main() method in your main class will just create a main.Simulation object and call its run() for a
desired length. Parameter values such as arrival time rate can be passed to constructor or set
individually.

You will be able to re-use much of the above described machinery in your traffic project.
*/
public class Simulation {
    double currentTime = 0;
    double stopTime;
    ArrivalProcess arrivals;


    Simulation( double sim_time ) {
        stopTime = sim_time;
    }

    void run(  ) {

    }

    void doLoop(  ) {
        while( currentTime < stopTime ) {

        }
    }

   
}
