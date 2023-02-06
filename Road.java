import java.util.*;

public class Road {
    //fields
    private Station[] stops;
    private int length;
    private car[] cars;

    //constructors
    public Road(){
        stops = new Station[31];
        for(int i = 0; i < stops.length; i++){
            stops [i] = new Station(i); //makes a new station with number
        }

        //manually put some passengers in
        stops[0].addPassenger(new Passenger(0, 3));
    }

    //methods
    public void update(){
        
    }
}