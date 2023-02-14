
public class Passenger {
    //fields
    private int finalDestination;
    private int start;
    private static int IDgenerator = 1;
    private int ID;

    //constructors
    public Passenger(){
        finalDestination = (int)(Math.random() * 31);
        start  = (int)(Math.random() * 31);
        ID = IDgenerator;
        IDgenerator++;
    }

    //methods
    /**
     * this method returns the passenger's final destination (randomly assigned to one of the 31 stations)
     */
    public int getFinal(){
        return finalDestination;
    }

    /**
     * this method returns the passenger's starting location (randomly assigned to one of the 31 stations)
     */
    public int getStart(){
        return start;
    }

    /**
     * toString returns passenger#, starting location, and destination
     * @return the String with passengers's information
     */
    public String toString(){
        return "Passenger#" + ID + "start: " + start + ", final destination: " + finalDestination;
    }
}