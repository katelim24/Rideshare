import java.util.*;

public class Station {
    //fields
    private ArrayList<Passenger> passengers;
    private int num;

    //constructors
    public Station(int myNum){
        num = myNum;
        passengers = new ArrayList<Passenger>();
    }


    //methods
    public void addPassenger(Passenger a){
        passengers.add(a);
    }

    public void removePassenger(int pos){
        passengers.remove(pos);
    }

    public ArrayList<Passenger> getList(){
        return passengers;
    }

    public String toString(){
        return "Passengers" + passengers + "Station num" + num;
    }
}
