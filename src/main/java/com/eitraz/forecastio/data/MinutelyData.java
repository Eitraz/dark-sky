
package com.eitraz.forecastio.data;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "time",
        "precipIntensity",
        "precipIntensityError",
        "precipProbability",
        "precipType"
})
public class MinutelyData {
    @JsonProperty("time")
    private Long time;
    @JsonProperty("precipIntensity")
    private Double precipIntensity;
    @JsonProperty("precipIntensityError")
    private Double precipIntensityError;
    @JsonProperty("precipProbability")
    private Double precipProbability;
    @JsonProperty("precipType")
    private String precipType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Long time) {
        this.time = time;
    }

    @JsonProperty("precipIntensity")
    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    @JsonProperty("precipIntensity")
    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    @JsonProperty("precipIntensityError")
    public Double getPrecipIntensityError() {
        return precipIntensityError;
    }

    @JsonProperty("precipIntensityError")
    public void setPrecipIntensityError(Double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    @JsonProperty("precipProbability")
    public Double getPrecipProbability() {
        return precipProbability;
    }

    @JsonProperty("precipProbability")
    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    @JsonProperty("precipType")
    public String getPrecipType() {
        return precipType;
    }

    @JsonProperty("precipType")
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
