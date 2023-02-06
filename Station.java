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
    /**
     * this adds a new passenger to the passenger list
     * @param a the passanger to be added in
     */
    public void addPassenger(Passenger a){
        passengers.add(a);
    }

    /**
     * this removes a passenger from the passenger list
     * @param pos the position of the passenger to be removed
     */
    public void removePassenger(int pos){
        passengers.remove(pos);
    }

    /**
     * 
     * @return
     */
    public ArrayList<Passenger> getList(){
        return passengers;
    }

    public String toString(){
        return "Passengers: " + passengers + "Station num: " + num;
    }

    /**
     * 
     * @return
     */
    public Passenger nextLeftPassenger(){

    }
}
