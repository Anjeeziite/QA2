import org.junit.jupiter.api.Test;

public class HomeWork2 {
    @Test
    public void wordCount() {
        String Line1 = "We take 120000 with interest rate of 0.028, after 20 you will pay total amount of 187200.0";

        System.out.println("String Length: " + Line1.length());
        System.out.println("Word count is: " + Line1.split("\\s+").length);


    }
}
