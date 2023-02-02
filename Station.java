import java.util.*;

public class Station {
    //fields
    private ArrayList<passenger> passengers;

    //constructors
    public Station(){
        passengers = new ArrayList<passenger>();
    }


    //methods
    public void addPassenger(passenger a){
        passengers.add(a);
    }

    public void removePassenger(int pos){
        passengers.remove(pos);
    }

    public ArrayList<passenger> getList(){
        return passengers;
    }
}
