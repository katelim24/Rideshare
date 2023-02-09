public class Runner {
    public static void main(String[] args) {
        System.out.println("Testing the road...");
        Road r = new Road();

        System.out.println("Printing the starting road -->");
        System.out.println();
        r.populate();
        System.out.println(r);

        System.out.println("Moving -->");
        System.out.println();
        r.update2();
        System.out.println(r);

        System.out.println("Final Revenue: $" + r.avgRevenue()); //need to loop through passengers and then calculate total revenue
        //System.out.println(r.getRevenue());
    }
}
