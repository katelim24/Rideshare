import java.util.*; 
public class Passenger {
    //fields
    private int finalDestination;
    private int start;

    //constructors
    public Passenger(int myStart, int myDestination){
        //finalDestination = (int)Math.random() * 31 + 1;
        //start  = (int)Math.random() * 31 + 1;
        start = myStart;
        finalDestination = myDestination;
    }

    //methods

    public int getFinal(){
        return finalDestination;
    }

    public int getStart(){
        return start;
    }

    public String toString(){
        return "Starting station: " + start + ", final destination: " + finalDestination;
    }
}