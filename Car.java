import java.util.*;

public class Car {
    //fields
    private ArrayList<Passenger> passList;
    //private static int totalRev = 0;
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
    }
    
    //methods
    public int getLocation(){
        return location;
    }

    public int getDestination(){
        return destination;
    }
    

    public void drive(){
        if(isParked == false){
            if(location == destination){
                isParked = true;
            } else if (destination - location > 0){
                location ++;
            } else {
                location --;
            }
        }
    }

    /**
     * if(currentStation.hasRightPassanger() == true){
                Passenger p = currentStation.nextRightPassenger();
                p.updateLocation(1);
            } else if(currentStation.hasLeftPassenger() == true){
                Passenger p = currentStation.nextLeftPassenger();
                p.updateLocation(-1);
            }
     */

    public void pickup(Station a, Passenger p){
        a.removePassenger(p);
        if(passList.size() < 3){
            passList.add(p);
        }
    }

    public void dropOff(Passenger p, Station a){
        a.addPassengerStation(p, a);
        passList.remove(p);
    }

    public String toString(){
        return "Car#" + ID + " Location: " + location +  " Destination: " + destination + " Passengers: " + passList;
        //+ " Miles Traveled: " + milesTraveled
    }

    public ArrayList<Passenger> getPassList(){
        return passList;
    }
}
