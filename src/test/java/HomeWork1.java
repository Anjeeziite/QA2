import org.junit.jupiter.api.Test;

public class HomeWork1 {

    @Test
    public void creditCalculation() {
        int creditSum = 120000;
        double creditPercent = 0.028;
        int periodYears = 20;

        Double totalSum = creditSum * (1 + periodYears * creditPercent);

        System.out.println("We take " + creditSum + " with interest rate of " + creditPercent +
                ", after " + periodYears + " you will pay total amount of " + totalSum);


    }
}
