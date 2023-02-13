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
    public int getLocation(){
        return location;
    }

    public int getDestination(){
        return destination;
    }
    

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
