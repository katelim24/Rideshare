import java.util.*;

public class Car {
    //fields
    private ArrayList<Passenger> passList;
    private static int totalRev = 0;
    private int milesTraveled;
    private int location;
    private int destination;
    private int direction;
    private boolean isParked;
    private static int IDgenerator = 1;
    private int ID;

    //constructors
    public Car(){
        passList = new ArrayList<Passenger>();
        milesTraveled = 0;
        totalRev = 0;
        ID = IDgenerator;
        IDgenerator ++;
        location = (int)(Math.random() * 31 + 1);
        destination = (int)(Math.random() * 31 + 1);
        isParked = false;
        if(location < destination){
            direction = 1;
        } else{
            direction = -1;
        }
<<<<<<< HEAD
        location = (int)(Math.random() * 31);
        destination = (int)(Math.random() * 31);
        isParked = false;
=======
>>>>>>> 42df00ef9d6726113719bef5a9e884e2c905d243
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
            milesTraveled ++;
        }
    }

    public void pickup(Station a, Passenger p){
        a.removePassenger(location);
        if(passList.size() - 1 < 3){
            passList.add(p);
        }
    }

    public void dropOff(Passenger p, Station a){
        a.addPassengerStation(p, a);
        passList.remove(p);
    }

    public String toString(){
        return "Car#" + ID + " Loc: " + location +  " Dest: " + destination + " Passengers: " + passList + " Miles Traveled: " + milesTraveled;
    }

    public ArrayList<Passenger> getPassList(){
        return passList;
    }
}
