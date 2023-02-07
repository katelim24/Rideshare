import java.util.*;

public class Station {
    //fields
    private ArrayList<Passenger> passengers;
    private int num;
    private ArrayList<Car> cars;

    //constructors
    public Station(int myNum){
        num = myNum;
        passengers = new ArrayList<Passenger>();
        cars = new ArrayList<Car>();
    }


    //methods
    /**
     * this adds a new passenger to the passenger list
     * @param p the passanger to be added in
     */
    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    /**
     * this removes a passenger from the passenger list
     * @param pos the position of the passenger to be removed
     */
    public void removePassenger(int pos){
        passengers.remove(pos);
    }

    /**
     * returns the list of passengers
     * @return 
     */
    public ArrayList<Passenger> getList(){
        return passengers;
    }


    public ArrayList<Car> getCarList(){
        return cars;
    }

    public void removeCar(Car c){
        cars.remove(c);
    }

    public void addCar(Car c){
        cars.add(c);
    }

    /**
     * hands off the next passenger that is trying to go left
     * note that it removes the passenger from the station before returning it
     * @return the next passenger going to the left
     */
    public Passenger nextLeftPassenger(){
        for(int i = 0; i < passengers.size(); i++){
            Passenger p = passengers.get(i);
            if(p.getFinal() < num){
                passengers.remove(i);
                return p;
            }
        }
        return null;
    }

    public boolean hasLeftPassenger(){
        //almost identical to nextLeftPassenger, but return true/false
        for(int i = 0; i < passengers.size(); i++){
            Passenger p = passengers.get(i);
            if(p.getFinal() < num){
                return true;
            }
        }
        return false;
    }


    public Passenger nextRightPassenger(){
        for(int i = 0; i < passengers.size(); i++){
            Passenger p = passengers.get(i);
            if(p.getFinal() > num){
                passengers.remove(i);
                return p;
            }
        }
        return null;
    }

    public boolean hasRightPassanger(){
        for(int i = 0; i < passengers.size(); i++){
            Passenger p = passengers.get(i);
            if(p.getFinal() > num){
                return true;
            }
        }
        return false;
    }


    public String toString(){
        return "Passengers: " + passengers + "Station num: " + num;
    }

    }
