import java.util.*;

public class Car {
    //fields
    private int numPassengers;
    private ArrayList<Passenger> passList;
    private int moneyEarned;
    private int location;
    private int start;
    private int finalDestination;
    private boolean isGoingForward;

    //constructors
    public Car(){
        numPassengers = 0;
        moneyEarned = 0;
        start = (int)Math.random() * 31 + 1;
        location = start;
        finalDestination = (int)Math.random() * 31 + 1;
        isGoingForward = true;
    }

    //methods
    public void drive(){
        location += 1;
    }

    public void pickup(Station a, Passenger b){
        a.removePassenger(location);
        passList.add(b);
    }

    //add dropoff method
}
