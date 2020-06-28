import org.junit.jupiter.api.Test;

public class JavaPractice { //Always write Class with big letter
    //You can write any comment, no need to close, when sending code, dont add comments in final work
    /*
    comments
    in
    multiple
    lines
     */
    @Test
    public void firstJavaCode() {
        Double distance = 135.7;
        Double fuelAmount = 20.00;

        double ticketMonthlyPrice = 50.00;
        int ridesCount = 80;

        int zojaRidesCount = 2;

        double consumption = fuelAmount / distance * 100;

        double pricePerRide = calculatePricePerRide(ridesCount);
        double pricePerRideForZoja = calculatePricePerRide(zojaRidesCount);

        System.out.println("Current fuel consumption is: " + consumption + " but using trolley it costs " + pricePerRide +
                " per month" + " and now Zoja spend " + pricePerRideForZoja + " per ride");
        //sout - shortcut


        int a = 15;
        int b = 10;

        String c = "15";
        String d = "10";

        System.out.println(a + b);
        System.out.println(c + d);
    }

    private double calculatePricePerRide(int ridesCount) {
        final double PRICE = 50.00;

        double pricePerRide = PRICE / ridesCount;
        return pricePerRide;

    }
}
