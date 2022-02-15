package com.moviesproject.moviesproject.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherDate {
    private Coord coord;
    private String base;
    private String name;
    private long timezone;
    private long id;
    private int cod;
    private double visibility;
    private long dt;
    private Clouds clouds;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;

    @Data
    public static class Clouds {
        private int all;

    }

    @Data
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class Coord {
        private double lon;
        private double lat;
    }

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private long pressure;
        private int humidity;
        private long sea_level;
        private long grnd_level;
    }

    @Data
    public static class Wind {
        private double speed;
        private double deg;
        private double gust;
    }

    @Data
    public static class Sys {
        private int type;
        private long id;
        private String country;
        private long sunrise;
        private long sunset;
    }
}
