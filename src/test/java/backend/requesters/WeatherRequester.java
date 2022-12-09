package backend.requesters;

import backend.model.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?id=";
    private final String POSTFIX = "&appid=b6907d289e10d714a6e88b30761fae22";

    public WeatherResponse requestWeather(long city) throws JsonProcessingException {
        String url = PREFIX + city + POSTFIX;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        String jsonToParse = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonToParse, WeatherResponse.class);
    }
}
