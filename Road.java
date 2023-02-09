import java.util.*;

public class Road {
    //fields
    private Station[] stations;
    private Car[] cars;
    private Passenger[] passengers;
    private Car c;

    //constructors
    public Road(){
        stations = new Station[31];
        for(int i = 0; i < stations.length; i++){
            stations [i] = new Station(i); //makes a new station with number
        }
        cars = new Car[10];
        passengers = new Passenger[30];
    }

    //methods
    public void populate(){
        for (int i = 0; i < 31; i++){
            Station s = new Station(i);
            stations[i] = s;
        }
        for (int i = 0; i < 9; i++){
            Car c = new Car();
            cars[i] = c;
            stations[c.getLocation()].addCar(c);
        }
        for (int i = 0; i < 29; i++){
            Passenger p = new Passenger();
            stations[p.getStart()].addPassenger(p);
        }
    }

    public void update(){
        for (int i = 0; i < cars.length; i++){
            if(cars[i].getDestination() - cars[i].getLocation() > 0){
                if(stations[i].hasRightPassanger() == true){
                    Passenger p = stations[i].nextRightPassenger();
                    cars[i].pickup(stations[i], p);
                }
            } else if(cars[i].getDestination() - cars[i].getLocation() < 0){
                if(stations[i].hasLeftPassenger() == true){
                    Passenger p = stations[i].nextLeftPassenger();
                    cars[i].pickup(stations[i], p);
                }
            }
            //loops through passangers in each car
            for (int j = 0; j < cars[i].getPassList().size(); j++){
                if(cars[i].getPassList().get(j).getFinal() == cars[i].getLocation()){
                    cars[i].dropOff(cars[i].getPassList().get(j));
                    stations[i].addPassenger(cars[i].getPassList().get(j), cars[i]);
                }
            }
            cars[i].drive();
            stations[cars[i].getLocation()].removeCar(cars[i]);
        }

    }

    public void update2(){
        for (int i = 0; i < cars.length; i++){
            Car currentCar = cars[i];
            int currentStationNum = currentCar.getLocation();
            Station currentStation = stations[currentStationNum];


            //load all possible passangers
            if(currentCar.getDestination() - currentCar.getLocation() > 0){
                //picking up right passanger
                if(currentStation.hasRightPassanger() == true){
                    Passenger p = currentStation.nextRightPassenger();
                    currentCar.pickup(p);
                }
            } else if(currentCar.getDestination() - currentCar.getLocation() < 0){
                //picking up left passanger
                if(currentStation.hasLeftPassenger() == true){
                    Passenger p = currentStation.nextLeftPassenger();
                    currentCar.pickup(p);
                }
            }
            //remove car and passanger from current station list
            for (int j = 0; j < currentCar.getPassList().size(); j++){
                Passenger p = currentCar.getPassList().get(j); //gets each passanger
                currentStation.removePassenger(p); //removes each passanger from station list
            }
            currentStation.removeCar(currentCar); //removes each car from station list

            //move car to next station
            currentCar.drive();
            int updatedCurrentStationNum = currentCar.getLocation(); //update car location
            Station updatedCurrentStation = stations[updatedCurrentStationNum]; //update car station
            
            
            //add car to new station list
            updatedCurrentStation.addCar(currentCar);

            //loop through pass list 
            for (int j = 0; j < currentCar.getPassList().size(); j++){
                Passenger p = currentCar.getPassList().get(j); //gets each passanger
                int passDest = p.getDestination();
                //check to see if passanger needs to be dropped off
                if(passDest == currentStationNum){
                    currentCar.dropOff(p); //drop off if so
                    currentStation.addPassanger(p); //add passanger to current station
                }
            }
        }
    }

    public String toString(){
        //put the stations in the toString with some spacing in between
        String s = super.toString();
        for(Station st : stations){
            s += st.toString() + "\n";
        }
        for(Car c : cars){
            s += c.toString() + "\n";
        }
        return s;
    }
}