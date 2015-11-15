package com.eitraz.forecastio;

import java.util.Date;

public class ForecastIO {
    private static final String API_URL = "https://api.forecast.io/forecast";

    private final String apiKey;
    private Units units = Units.AUTO;

    public ForecastIO(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getForecast(double latitude, double longitude) {
        return getForecast(latitude, longitude, null);
    }

    public String getForecast(double latitude, double longitude, Date time) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(String.format("%s/%s/%s,%s", API_URL, apiKey, latitude, longitude));

        // Get forecast for specific time
        if (time != null) {
            urlBuilder.append(String.format(",%d", time.getTime()));
        }

        // Units
        urlBuilder.append("?units=").append(units.toString().toLowerCase());

        return urlBuilder.toString();
    }
}
