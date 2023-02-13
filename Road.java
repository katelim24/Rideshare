import java.util.*;

public class Road {
    //fields
    private Station[] stations;
    private Car[] cars;

    //constructors
    public Road(){
        stations = new Station[31];
        /**
         * for(int i = 0; i < stations.length; i++){
            stations [i] = new Station(i); //makes a new station with number
        }
         */
        cars = new Car[10];

    }

    //methods
    public void populate(){
        for (int i = 0; i < 31; i++){
            Station s = new Station(); //Station s = new Station(i);
            stations[i] = s;
        }
        for (int i = 0; i < 10; i++){
            Car c = new Car();
            cars[i] = c;
            stations[c.getLocation()].addCar(c);
        }
        for (int i = 0; i < 30; i++){
            Passenger p = new Passenger();
            stations[p.getStart()].addPassengerCar(p, cars[(int)(Math.random() * 9)]); //instead of cars[i] bc cars is only 10 things long
        }
    }

     public void update(){
        for (int i = 0; i < cars.length; i++){
            Car currentCar = cars[i];
            int currentStationNum = currentCar.getLocation();
            Station currentStation = stations[currentStationNum];


            //load all possible passangers
            if(currentCar.getDestination() - currentCar.getLocation() > 0){
                //picking up right passanger
                //System.out.println("trying to move a right person...");
                if(currentStation.hasRightPassanger() == true){
                    Passenger p = currentStation.nextRightPassenger();
                    currentCar.pickup(currentStation, p);
                }
            } else if(currentCar.getDestination() - currentCar.getLocation() < 0){
                //picking up left passanger
                //System.out.println("trying to move a left person...");
                if(currentStation.hasLeftPassenger() == true){
                    Passenger p = currentStation.nextLeftPassenger();
                    currentCar.pickup(currentStation, p);
                }
            }
            //remove car and passanger from current station list
            //System.out.println("trying to remove passenger from staton...");
            
            currentStation.removeCar(currentCar); //removes each car from station list

            //move car to next station
            //System.out.println("trying to move a car to next station...");
            currentCar.drive();
            int updatedCurrentStationNum = currentCar.getLocation(); //update car location
            Station updatedCurrentStation = stations[updatedCurrentStationNum]; //update car station
            
            
            //add car to new station list
            //System.out.println("trying to add car to new station...");
            updatedCurrentStation.addCar(currentCar);

            //loop through pass list 
            for (int j = 0; j < currentCar.getPassList().size(); j++){
                //System.out.println("checks if passenger needs to be dropped off...");
                Passenger p = currentCar.getPassList().get(j); //gets each passanger
                int passDest = p.getFinal();
                //check to see if passenger needs to be dropped off
                if(passDest == currentStationNum){
                    currentCar.dropOff(p, currentStation); //drop off if so
                    currentStation.addPassengerCar(p, currentCar); //add passenger to current station
                }
            }
        }
    }

    public double avgRevenue(){
        double avrg = Car.totalRev/cars.length;
        return avrg;
    }
    

    /**
     * Sum up all the miles traveled (which you're doing right now)
Determine how many passengers there are
Calculate the average at the end by dividing the sum by total number of passengers.
Right now your average is being calculated using multiple division operations since it's in a for loop, but you should only perform one division operation at the very end.

     */
    
    public String toString(){
        //put the stations in the toString with some spacing in between
        //String s = super.toString();
        String s = "";
        for(Station st : stations){
            s += st.toString() + "\n";
        }
        for(Car c : cars){
            s += c.toString() + "\n";
        }
        return s;
    }
}