package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.model.WeatherDate;
import com.moviesproject.moviesproject.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControllerWeather {

    @Autowired
    private final WeatherService weatherService;

    @GetMapping("/get-weather")
    public WeatherDate getWeather(String location){
        return weatherService.getWeather(location);
    }

}
