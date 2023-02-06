public class Runner {
    public static void main(String[] args) {
        System.out.println("Testing Passenger...");
        Passenger one = new Passenger(0, 3);
        Passenger two = new Passenger(3, 2);
        Passenger three = new Passenger(1, 4);

        


        System.out.println("Testing station...");
        Station a = new Station(5);
        a.addPassenger(one);
        a.addPassenger(two);
        a.addPassenger(three);
        System.out.println("Added 3 passengers..." + a.toString());
        a.removePassenger(1);


        System.out.println("Testing the road...");
        Road r = new Road();

        System.out.println("Testing the car...");
        Car c = new Car();
        System.out.println("Printing the current road...");
        System.out.println(r.toString());
        c.drive();
        c.pickup(a, one);
        System.out.println("driving cars...");
        System.out.println("picking up passengers...");
        System.out.println("Printing the current road...");
        //c.dropoff;



    }
}
