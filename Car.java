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
        location = (int)(Math.random() * 32);
        destination = (int)(Math.random() * 32);
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
        return "Car#" + ID + " Loc: " + location +  " Dest: " + destination + " Passengers: " + passList;
        //+ " Miles Traveled: " + milesTraveled
    }

    public ArrayList<Passenger> getPassList(){
        return passList;
    }
}
