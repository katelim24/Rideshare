import java.util.*; 
public class Passenger {
    //fields
    private int finalDestination;
    private int start;

    //constructors
    public Passenger(){
        finalDestination = (int)Math.random() * 31 + 1;
        start  = (int)Math.random() * 31 + 1;
    }

    //methods

    public int getFinal(){
        return finalDestination;
    }
}