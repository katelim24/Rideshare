import java.util.*; 
public class passenger {
    //fields
    private int finalDestination;
    private int start;

    //constructors
    public passenger(){
        finalDestination = (int)Math.random() * 31 + 1;
        start  = (int)Math.random() * 31 + 1;
    }

    //methods

    public int getFinal(){
        return finalDestination;
    }
}