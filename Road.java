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
    /**
     * this method populates the road with 31 stations. it adds 10 cars (for scenario 2) to the station's
     * car list, then adds 30 passengers to random cars.
     */
    public void populate(){
        for (int i = 0; i < 31; i++){
            Station s = new Station();
            stations[i] = s;
        }
        for (int i = 0; i < 10; i++){
            Car c = new Car();
            cars[i] = c;
            stations[c.getLocation()].addCar(c);
        }
        for (int i = 0; i < 30; i++){
            Passenger p = new Passenger();
            stations[p.getStart()].addPassengerCar(p, cars[(int)(Math.random() * 9)]);
        }
    }

    /**
     * this method updates the road each time the car moves. it keeps track of the car's location, destination, 
     * and passengers. it picks up passengers at their respective stations if they are going in the same direction
     * as the car, and each time the car drives, it is removed from the station and added to the next one. 
     */
    public void update(){
        for (int i = 0; i < cars.length; i++){
            Car currentCar = cars[i];
            int currentStationNum = currentCar.getLocation();
            Station currentStation = stations[currentStationNum];


            //load all possible passangers
            if(currentCar.getDestination() - currentCar.getLocation() > 0){
                //picking up right passanger and trying to move a right person
                if(currentStation.hasRightPassanger() == true){
                    Passenger p = currentStation.nextRightPassenger();
                    currentCar.pickup(currentStation, p);
                }
            } else if(currentCar.getDestination() - currentCar.getLocation() < 0){
                //picking up left passanger and trying to move a left person
                if(currentStation.hasLeftPassenger() == true){
                    Passenger p = currentStation.nextLeftPassenger();
                    currentCar.pickup(currentStation, p);
                }
            }
            //removes each car from station list
            currentStation.removeCar(currentCar); 

            //move car to next station
            currentCar.drive();
            int updatedCurrentStationNum = currentCar.getLocation(); //updates car location
            Station updatedCurrentStation = stations[updatedCurrentStationNum]; //updates car station
            
            
            //add car to new station list
            updatedCurrentStation.addCar(currentCar);

            //loop through pass list 
            for (int j = 0; j < currentCar.getPassList().size(); j++){
                //checks if passenger needs to be dropped off
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

    /**
     * calculates the average revenue from each simulation
     * @return the average calculated by total revenue of all cars ÷ amount of cars
     */
    public double avgRevenue(){
        double avrg = Car.totalRev/cars.length;
        return avrg;
    }
    
    /**
     * toString returns list of stations with cars and passengers, and returns car's location and destination
     * @return road's information
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