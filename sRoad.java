import java.util.*;
public class sRoad {
    //fields
    Station[] stations;
    Car[] cars;

    //constructor
    public Road(){
        stations = new Station[32];
        cars = new Car[10];
    }

    public void populate(){
        for (int i = 0; i <= 31; i++){
            Station s = new Station();
            stations[i] = s;
        }
        for (int i = 0; i <= 9; i++){
            Car c = new Car();
            cars[i] = c;
            stations[c.getLoc()].addCar(c);
        }
        for (int i = 0; i <= 29; i++){
            Passanger p = new Passanger();
            stations[p.getLoc()].addPassanger(p);
        }
    }

    public void update(){ //COMPLICATED ONE
        for (int i = 0; i < cars.length; i++){
            if(cars[i].getDest() - cars[i].getLoc() > 0){
                if(stations[i].hasRightPassanger() == true){
                    Passanger p = stations[i].nextRightPassanger();
                    cars[i].pickup(p);
                }
            } else if(cars[i].getDest() - cars[i].getLoc() < 0){
                if(stations[i].hasLeftPassanger() == true){
                    Passanger p = stations[i].nextLeftPassanger();
                    cars[i].pickup(p);
                }
            }
            //loops through passangers in each car
            for (int j = 0; j < cars[i].getPassList().size(); j++){
                if(cars[i].getPassList().get(j).getDest() == cars[i].getLoc()){
                    cars[i].dropOff(cars[i].getPassList().get(j));
                    stations[i].addPassanger(cars[i].getPassList().get(j));
                }
            }
            cars[i].move();
            stations[cars[i].getLoc()].removeCar(cars[i]);
        }

    }

    public String toString(){
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