public class Runner {
    public static void main(String[] args) {
        System.out.println("Testing Passenger...");
        Passenger one = new Passenger(0,7);
        Passenger two = new Passenger(7,5);
        Passenger three = new Passenger(2,9);

        
        System.out.println("Testing station...");
        Station a = new Station(5);
        a.addPassenger(one);
        a.addPassenger(two);
        a.addPassenger(three);
        System.out.println("Added 3 passengers..." + a.toString());
        a.removePassenger(1);

    }
}
