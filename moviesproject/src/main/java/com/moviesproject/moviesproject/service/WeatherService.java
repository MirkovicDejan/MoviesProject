package com.moviesproject.moviesproject.service;
import com.moviesproject.moviesproject.model.WeatherDate;
import com.moviesproject.moviesproject.typ.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    @PostConstruct
    public void init(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("x-rapidapi-host","community-open-weather-map.p.rapidapi.com");
        headers.add("x-rapidapi-key","98dbbd5e67msh6329b6ea23b3979p17dbe6jsnbb0a1fba872f");
    }

    public WeatherDate getWeather(String location) {
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<WeatherDate> responseEntity = restTemplate.exchange(URL.URL_WEATHER.getUrl()+location,HttpMethod.GET,requestEntity, WeatherDate.class);
        return responseEntity.getBody();

    }
}
