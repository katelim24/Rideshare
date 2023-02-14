import java.util.*;

public class Car {
    //fields
    private ArrayList<Passenger> passList;
    static int totalRev;
    //private int milesTraveled;
    private int location;
    private int destination;
    //private int direction;
    private boolean isParked;
    private static int IDgenerator = 1;
    private int ID;

    //constructors
    public Car(){
        passList = new ArrayList<Passenger>();
        ID = IDgenerator;
        IDgenerator ++;
        location = (int)(Math.random() * 31);
        destination = (int)(Math.random() * 31);
        isParked = false;
        totalRev = 0;
    }
    
    //methods
    /**
     * this method returns the car's location (randomly assigned at start)
     * @return location
     */
    public int getLocation(){
        return location;
    }

    /**
     * this method returns the car's final destination (randomly assigned from 31 stations)
     * @return destination
     */
    public int getDestination(){
        return destination;
    }
    
    /**
     * the drive method allows the car to move forward one station in the direction of their destination. 
     * if the car is already at their destination, it will no longer move and be "parked".
     */
    public void drive(){
        totalRev += passList.size();
        if(isParked == false){
            if(location == destination){
                isParked = true;
            } else if (destination - location > 0){
                location ++;
                System.out.println("DEBUG LOCATION: " + location);
            } else {
                location --;
                System.out.println("DEBUG LOCATION: " + location);
            }
        }
    }

    /**
     * the passenger is removed from the station's passenger list by calling on the removePassenger method, 
     * checks to make sure there are less than 3 passengers in car before it picks up the passenger
     * @param a the station you are removing the passenger from (wehre car is)
     * @param p the passenger you want to remove
     */
    public void pickup(Station a, Passenger p){
        a.removePassenger(p);
        if(passList.size() < 3){
            passList.add(p);
        }
    }

    /**
     * dropOff adds the passenger you are dropping off to the current station, then removes it from the car's 
     * passenger list.
     * @param p passenger you want to remove from the car
     * @param a station you want to drop the passenger off at
     */
    public void dropOff(Passenger p, Station a){
        a.addPassengerStation(p, a);
        passList.remove(p);
    }


    /**
     * toString returns car#, where it is, where it is going, and which passengers it has
     * @return the String with car's information
     */
    public String toString(){
        return "Car#" + ID + " Location: " + location +  " Destination: " + destination + " Passengers: " + passList;
        //+ " Miles Traveled: " + milesTraveled
    }

    /**
     * @return car's passenger list
     */
    public ArrayList<Passenger> getPassList(){
        return passList;
    }
}
