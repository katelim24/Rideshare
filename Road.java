import java.util.*;

public class Road {
    //fields
    private Station[] stops;
    private int length;
    private Car[] cars;
    private Car c;

    //constructors
    public Road(){
        stops = new Station[31];
        for(int i = 0; i < stops.length; i++){
            stops [i] = new Station(i); //makes a new station with number
        }

        //manually put some passengers in
        stops[0].addPassenger(new Passenger(0, 3));
        stops[0].addPassenger(new Passenger(0, 1));
        stops[3].addPassenger(new Passenger(3, 4));
        stops[3].addPassenger(new Passenger(3, 1));

        c = new Car();
    }

    //methods
    public String toString(){
        String s = super.toString();

        //put the stations in the toString with some spacing in between
        for(Station st : stops){
            s += st + "\n\n";
        }
        return s;
    }
    
    
    public void update(){
        c.drive();
    }
}