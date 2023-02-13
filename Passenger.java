
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

    public int getFinal(){
        return finalDestination;
    }

    public int getStart(){
        return start;
    }

    public String toString(){
        return "Passenger#" + ID + "start: " + start + ", final destination: " + finalDestination;
    }
}