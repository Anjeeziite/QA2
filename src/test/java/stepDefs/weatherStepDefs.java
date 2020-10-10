package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WheatherRequester;


public class weatherStepDefs {

    private String city;
    private String country;
    private model.Response response;
    private Object Response;

    @Given("city is: {string}")
    public void set_city(String city) {
        this.city = city;
    }

    @Given("country is: {string}")
    public void set_country(String country) {
        this.country = country.toLowerCase();
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
    WheatherRequester requester = new WheatherRequester();
    response = requester.requestWeather(city, country);

    }

    @Then("lon is: {double}")
    public void check_lon(Double lon){
        Assertions.assertEquals(lon, response.getCoord().getLon());
    }

    @Then("lat is: {double}")
    public void check_lat(Double lat){
        Assertions.assertEquals(lat, response.getCoord().getLat());
    }
    @Then("temp is: {double}")
    public void check_temp(Double temp){
        Assertions.assertEquals(temp, response.getMain().getTemp());
    }
    @Then("pressure is: {int}")
    public void check_pressure(int pressure){
        Assertions.assertEquals(pressure, response.getMain().getPressure());
    }
    @Then("humidity is: {int}")
    public void check_humidity(int humidity){
        Assertions.assertEquals(humidity, response.getMain().getHumidity());

    }
}
