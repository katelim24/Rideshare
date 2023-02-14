import java.util.*;

public class Station {
    //fields
    private ArrayList<Passenger> passengers;
    private ArrayList<Car> cars;
    private int num;
    private static int numStationGenerator = 0;


    //constructors
    public Station(){
        passengers = new ArrayList<Passenger>();
        cars = new ArrayList<Car>();
        num = numStationGenerator;
        numStationGenerator ++; 
    }

    //methods
    /**
     * this adds a new passenger to the passenger list
     * @param p the passanger to be added in car
     */
    public void addPassengerCar(Passenger p, Car c){
        passengers.add(p);
    }

    /**
     * adds a new passenger to the station, used to drop off passenger at station
     * @param p passenger to be added to station
     * @param a station you are adding passenger to
     */
    public void addPassengerStation(Passenger p, Station a){
        passengers.add(p);
    }

    /**
     * this removes a passenger from the passenger list
     * @param p the passenger to be removed from the passenger list
     */
    public void removePassenger(Passenger p){
        passengers.remove(p);
    }

    /**
     * @return car's list of passengers
     */
    public ArrayList<Passenger> getPassList(){
        return passengers;
    }

    /**
     * @return station's list of cars
     */
    public ArrayList<Car> getCarList(){
        return cars;
    }

    /**
     * removes the car from car list
     * @param c car you want to remove
     */
    public void removeCar(Car c){
        cars.remove(c);
    }

    /**
     * adds the car to car list
     * @param c car you want to add
     */
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

    /**
     * checks if the car has a passenger going to the left
     * @return true if there is a passenger going left
     */
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

    /**
     * hands off the next passenger that is trying to go right
     * note that it removes the passenger from the station before returning it
     * @return the next passenger going to the right
     */
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

    /**
     * checks if the car has a passenger going to the right
     * @return true if there is a passenger going right
     */
    public boolean hasRightPassanger(){
        for(int i = 0; i < passengers.size(); i++){
            Passenger p = passengers.get(i);
            if(p.getFinal() > num){
                return true;
            }
        }
        return false;
    }

    /**
     * toString returns station#, cars in the station, and what passengers are in the cars in station
     * @return the String with stations's information
     */
    public String toString(){
        return "Station#" + num + " Cars: " + getCarList() + "Passengers: " + getPassList();
    }

}
