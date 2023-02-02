import java.util.*;

public class Station {
    //fields
    private ArrayList<Passenger> passengers;

    //constructors
    public Station(){
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
}
