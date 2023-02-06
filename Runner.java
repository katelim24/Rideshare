public class Runner {
    public static void main(String[] args) {
        System.out.println("Testing Passenger...");
        Passenger one = new Passenger();
        Passenger two = new Passenger();
        Passenger three = new Passenger();

        


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
        //c.dropoff;



    }
}
