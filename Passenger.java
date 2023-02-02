import java.util.*; 
public class passenger {
    //fields
    private int finalDestination;
    private int start;
    private int current;

    //constructors
    public passenger(){
        finalDestination = (int)Math.random() * 31 + 1;
        start  = (int)Math.random() * 31 + 1;
        current = 0;
    }

    //methods

    public int getFinal(){
        return finalDestination;
    }

    public String toString(){
        return "Starting station: " + start + ", final destination: " + finalDestination + ", current position: " + current;
    }
}