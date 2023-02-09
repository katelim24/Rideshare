
public class Passenger {
    //fields
    private int finalDestination;
    private int start;

    //constructors
    public Passenger(){
        finalDestination = (int)(Math.random() * 31);
        start  = (int)(Math.random() * 31);
    }

    //methods

    public int getFinal(){
        return finalDestination;
    }

    public int getStart(){
        return start;
    }

    public int getMilesTraveled(){  //revenue
        return Math.abs(finalDestination - start);
    }

    public String toString(){
        return "Starting station: " + start + ", final destination: " + finalDestination;
    }
}