package com.eitraz.darksky;

import com.eitraz.darksky.data.Forecast;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class DarkSkyTest {
    private static final String API_KEY = System.getProperty("apiKey");
    private static final Double LATITUDE = 59.332722;
    private static final Double LONGITUDE = 18.068565;

    private DarkSky io;

    @Before
    public void setUp() throws Exception {
        assertFalse("No API key provided, use -DapiKey=[API-KEY] when building", StringUtils.isBlank(API_KEY));
        io = new DarkSky(API_KEY);
        io.setUnits(Units.SI);
        io.setLanguage(Language.ENGLISH);
    }

    @Test
    public void testSpecificTimeForecast() throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-15");
        Forecast forecast = io.getForecast(LATITUDE, LONGITUDE, date);

        assertNotNull(forecast);
        assertNotNull(new ObjectMapper().writeValueAsString(forecast));

        assertEquals(LATITUDE, forecast.getLatitude());
        assertEquals(LONGITUDE, forecast.getLongitude());
        assertEquals("Europe/Stockholm", forecast.getTimezone());
        assertEquals(new Long(1L), forecast.getOffset());
        assertEquals(new Long(date.getTime() / 1000), forecast.getCurrently().getTime());

        assertNotNull(forecast.getCurrently());
        assertNotNull(forecast.getHourly());
        assertNotNull(forecast.getDaily());
        assertNotNull(forecast.getAlerts());
        assertNotNull(forecast.getFlags());
    }

    @Test
    public void testCurrentForecast() throws Exception {
        // Doesn't seem to work for Stockholm - use example coordinates from https://developer.forecast.io/
        Forecast forecast = io.getForecast(37.8267, -122.423);

        assertNotNull(forecast);
        assertNotNull(new ObjectMapper().writeValueAsString(forecast));

        assertNotNull(forecast.getCurrently());
        assertNotNull(forecast.getMinutely());
        assertNotNull(forecast.getHourly());
        assertNotNull(forecast.getDaily());
        assertNotNull(forecast.getAlerts());
        assertNotNull(forecast.getFlags());
    }

    @Test
    public void testExcludes() throws Exception {
        io.setExcludes(DataBlock.CURRENTLY, DataBlock.HOURLY);
        Forecast forecast = io.getForecast(LATITUDE, LONGITUDE);

        assertNotNull(forecast);
        assertNotNull(new ObjectMapper().writeValueAsString(forecast));

        assertNull(forecast.getCurrently());
        assertNull(forecast.getHourly());
        assertNotNull(forecast.getDaily());
    }
}