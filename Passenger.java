
public class Passenger {
    //fields
    private int finalDestination;
    private int start;
    private int location;
    private static int IDgenerator = 1;
    private int ID;

    //constructors
    public Passenger(){
        finalDestination = (int)(Math.random() * 31);
        location  = (int)(Math.random() * 31);
        start = location;
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

    public void updateLocation(int direction){
        if(direction == 1){
            location++;
        } else{
            location--;   
        }
    }

    public int getMilesTraveled(){  //revenue
        return Math.abs(finalDestination - start);
    }

    public String toString(){
        return "Passenger#" + ID + "- location: " + location + ", final destination: " + finalDestination;
    }
}