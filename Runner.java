public class Runner {
    public static void main(String[] args) {
        Passenger one = new Passenger();
        Passenger two = new Passenger();
        Passenger three = new Passenger();

        
        Station a = new Station();
        a.addPassenger(one);
        a.addPassenger(two);
        a.addPassenger(three);
        System.out.println("Added 3 passengers..." + a.toString());
        a.removePassenger(passengers[1]);

    }
}
