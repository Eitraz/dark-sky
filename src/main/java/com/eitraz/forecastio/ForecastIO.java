package com.eitraz.forecastio;

import com.eitraz.forecastio.data.Forecast;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ForecastIO {
    protected static final Logger logger = Logger.getLogger(ForecastIO.class);

    private static final String API_URL = "https://api.forecast.io/forecast";

    private final String apiKey;

    private Units units = Units.AUTO;
    private Language language = Language.ENGLISH;
    private Set<DataBlock> excludes = new HashSet<>();

    public ForecastIO(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setExcludes(DataBlock... excludes) {
        this.excludes = new HashSet<>(Arrays.asList(excludes));
    }

    public Forecast getForecast(double latitude, double longitude) throws IOException {
        return getForecast(latitude, longitude, null);
    }

    public Forecast getForecast(double latitude, double longitude, Date time) throws IOException {
        String url = getUrl(latitude, longitude, time);
        logger.debug(String.format("Getting forecast from %s", url));

        URLConnection connection = new URL(url).openConnection();
        InputStream inputStream = connection.getInputStream();
        try {
            return new ObjectMapper().readValue(inputStream, Forecast.class);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    /**
     * @param latitude  latitude
     * @param longitude longitude
     * @param time      specific time for forecast, null for current
     * @return ForecastIO request URL
     */
    public String getUrl(double latitude, double longitude, Date time) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(String.format("%s/%s/%s,%s", API_URL, apiKey, latitude, longitude));

        // Get forecast for specific time
        if (time != null) {
            urlBuilder.append(String.format(",%d", time.getTime() / 1000));
        }

        // Options
        urlBuilder.append("?units=").append(units);
        urlBuilder.append("&lang=").append(language);

        if (!excludes.isEmpty()) {
            urlBuilder.append("&exclude=").append(StringUtils.join(excludes, ","));
        }
        return urlBuilder.toString();
    }

}
