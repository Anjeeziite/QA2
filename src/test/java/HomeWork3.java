import org.junit.jupiter.api.Test;

public class HomeWork3 {
    @Test
    public void gpsCoordinates() {
        double earthRadius = 6371;

        double lat = 33.505241;
        double lon = -6.835947;

        double lat2 = 12.003958;
        double lon2 = 15.928475;

        double distance = Math.acos(Math.sin(lat2 * Math.PI / 180) * Math.sin(lat * Math.PI / 180) +
                Math.cos(lat2 * Math.PI / 180) * Math.cos(lat * Math.PI / 180) *
                        Math.cos((lon-lon2) * Math.PI / 180)) * earthRadius;

        System.out.println("Distance is " + distance + "km");


    }
}
