import java.util.*;

public class Road {
    //fields
    private Station[] stations;
    private Car[] cars;
    private Car c;

    //constructors
    public Road(){
        stations = new Station[31];
        for(int i = 0; i < stations.length; i++){
            stations [i] = new Station(i); //makes a new station with number
        }
        c = new Car();
    }

    //methods
    public void populate(){
        for (int i = 0; i <= 31; i++){
            Station s = new Station();
            stations[i] = s;
        }
        for (int i = 0; i <= 9; i++){
            Car c = new Car();
            cars[i] = c;
            stations[c.getLocation()].addCar(c);
        }
        for (int i = 0; i <= 29; i++){
            Passenger p = new Passenger();
            stations[p.getLocation()].addPassenger(p);
        }
    }

    public void update(){ //COMPLICATED ONE
        for (int i = 0; i < cars.length; i++){
            if(cars[i].getDestination() - cars[i].getLocation() > 0){
                if(stations[i].hasRightPassanger() == true){
                    Passenger p = stations[i].nextRightPassenger();
                    cars[i].pickup(p);
                }
            } else if(cars[i].getDestination() - cars[i].getLocation() < 0){
                if(stations[i].hasLeftPassenger() == true){
                    Passenger p = stations[i].nextLeftPassenger();
                    cars[i].pickup(p);
                }
            }
            //loops through passangers in each car
            for (int j = 0; j < cars[i].getPassList().size(); j++){
                if(cars[i].getPassList().get(j).getDestination() == cars[i].getLocation()){
                    cars[i].dropOff(cars[i].getPassList().get(j));
                    stations[i].addPassenger(cars[i].getPassList().get(j));
                }
            }
            cars[i].drive();
            stations[cars[i].getLocation()].removeCar(cars[i]);
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