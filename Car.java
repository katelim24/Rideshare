import java.util.*;

public class Car {
    //fields
    private ArrayList<Passenger> passList;
    private int moneyEarned;
    private int location;
    private int destination;
    private int direction;

    //constructors
    public Car(int start, int stop){
        location = start;
        destination = stop;
        passList = new ArrayList<Passenger>();
        if(location < destination){
            direction = 1;
        } else{
            direction = -1;
        }
        moneyEarned = 0;
        start = (int)Math.random() * 31 + 1;
        location = start;
        destination = (int)Math.random() * 31 + 1;
    }

    //methods
    public void drive(){
        if(location != destination){
            location += direction;
        }
    }

    public String toString(){
        String s = super.toString();
        s += " Loc: " + location;
        s += " Dest: " + finalDestination;
        s += " Passengers: " + passList;
        return s;
    }

    public void pickup(Station a, Passenger b){
        a.removePassenger(location);
        passList.add(b);
    }

    //add dropoff method
}
