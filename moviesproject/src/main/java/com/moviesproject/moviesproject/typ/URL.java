package com.moviesproject.moviesproject.typ;

public enum URL {
    URL_WEATHER("https://community-open-weather-map.p.rapidapi.com/weather?q=");

    private final String url;

    URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
