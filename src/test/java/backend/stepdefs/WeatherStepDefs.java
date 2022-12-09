package backend.stepdefs;

import backend.model.WeatherResponse;
import backend.requesters.WeatherRequester;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WeatherStepDefs {
    @Given("city id: {int}")
    public void cityId(int cityId) {
    }

    @When("user requests weather data")
    public void userRequestsWeatherData() throws JsonProcessingException {
        WeatherRequester weatherRequester = new WeatherRequester();
        WeatherResponse response = weatherRequester.requestWeather(524901);

        System.out.println(response.getCoord().getLat());


    }

    @Then("received coords are:")
    public void receivedCoordsAre(Map<String, Double> params) {
        params.get("lon");
        params.get("lat");
    }

    @And("received weather is:")
    public void receivedWeatherIs(Map<String, String> params) {
        Long.parseLong(params.get("id"));
        params.get("main");
        params.get("description");
        params.get("icon");

    }

    @And("received base value id is: {string}")
    public void receivedBaseValueIdIs(String arg0) {
    }

    @And("received main is:")
    public void receivedMainIs(Map<String, Double> params) {
        params.get("temp");
        params.get("feels_like");
        params.get("temp_min");
        params.get("temp_max");
        params.get("pressure");
        params.get("humidity");
        params.get("sea_level");
        params.get("grnd_level");
    }

    @And("received visibility value is: {int}")
    public void receivedVisibilityValueIs(int arg0) {

    }

    @And("received wind is:")
    public void receivedWindIs(Map<String, Double> params) {
        params.get("speed");
        params.get("deg");
        params.get("gust");
    }

    @And("received rain is:")
    public void receivedRainIs(Map<String, Double> params) {
        params.get("1h");
    }

    @And("received clouds are:")
    public void receivedCloudsAre(Map<String, Integer> params) {
        params.get("all");
    }

    @And("received dt value is: {int}")
    public void receivedDtValueIs(int arg0) {
    }

    @And("received sys values are:")
    public void receivedSysValuesAre(Map<String ,String > params) {
        Integer.parseInt(params.get("type"));
        Long.parseLong(params.get("id"));
        params.get("country");
        Integer.parseInt(params.get("sunrise"));
        Integer.parseInt(params.get("sunset"));

    }

    @And("received timezone value is: {int}")
    public void receivedTimezoneValueIs(int arg0) {
    }

    @And("received id value is: {int}")
    public void receivedIdValueIs(int arg0) {
    }

    @And("received cod value is:{int}")
    public void receivedCodValueIs(int arg0) {
    }

    @And("received name is: {string}")
    public void receivedNameIs(String arg0) {
    }
}
