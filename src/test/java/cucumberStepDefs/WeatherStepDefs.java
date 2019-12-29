package cucumberStepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    //    @Given("Print welcome message")
//    public void print_message(){
//        System.out.println("Our first step ever!");

    private String city;
    private Response response;

    @Given("city is: (.*)")
    public void set_city(String city) {
        this.city = city;
    }

    @When("we are requesting weather")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(city);
    }

    @Then("lon is (.*)")
    public void check_lon(Double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");

    }

    @Then("lat is (.*)")
    public void check_lat(Double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");
    }

    @Then("id is (.*)")
    public void check_id(Double id) {
        Assertions.assertEquals(id, response.getWeather().get(0).getId(), "Wrong id");
    }

    @Then("main is (.*)")
    public void check_main(String main) {
        Assertions.assertEquals(main, response.getWeather().get(0).getMain(), "Wrong main");
    }

    @Then("description is (.*)")
    public void check_description(String description) {
        Assertions.assertEquals(description, response.getWeather().get(0).getDescription(), "Wrong description");
    }

    @Then("icon is (.*)")
    public void check_icon(String icon) {
        Assertions.assertEquals(icon, response.getWeather().get(0).getIcon(), "Wrong icon");
    }

    @Then("base is (.*)")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong base");
    }

    @Then("temp is (.*)")
    public void check_temp(Double temp) {
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong temp");
    }

    @Then("pressure is (.*)")
    public void check_pressure(Double pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong pressure");
    }

    @Then("humidity is (.*)")
    public void check_humidity(Double humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong humidity");
    }

    @Then("temp_min is (.*)")
    public void check_temp_min(Double temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong temp_min");
    }

    @Then("temp_max is (.*)")
    public void check_temp_max(Double temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong temp_max");
    }

    @Then("visibility is (.*)")
    public void check_visibility(Double visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @Then("speed is (.*)")
    public void check_speed(Double speed) {
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong speed");
    }

    @Then("deg is (.*)")
    public void check_deg(Double deg) {
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong deg");
    }

    @Then("all is (.*)")
    public void check_all(Integer all) {
        Assertions.assertEquals(all, response.getClouds().getAll(), "Wrong all");
    }

    @Then("dt is (.*)")
    public void check_dt(Integer dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @Then("type is (.*)")
    public void check_type (Integer type){
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong type");
    }
    @Then("id of the system is (.*)")
    public void check_sys_id (Integer sys_id){
        Assertions.assertEquals(sys_id, response.getSys().getId(), "Wrong System id");
    }
    @Then("message is (.*)")
    public void check_message (Double message){
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong message");
    }
    @Then("country is (.*)")
    public void check_country (String country) {
        Assertions.assertEquals(country, response.getSys().getCountry(), "Wrong country");
    }
    @Then("sunrise is (.*)")
    public void check_sunrise (Integer sunrise){
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sunrise");
    }
    @Then("sunset is (.*)")
    public void check_sunset (Integer sunset) {
        Assertions.assertEquals(sunset, response.getSys().getSunset());
    }
    @Then("id total is (.*)")
    public void check_total_id (int total_id) {
        Assertions.assertEquals(total_id, response.getId(), "Wrong total id");
    }
    @Then("name is (.*)")
    public void check_name (String name){
        Assertions.assertEquals(name, response.getName(), "Wrong name");
    }
    @Then("cod is (.*)")
    public void check_cod (int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod");
    }
}
