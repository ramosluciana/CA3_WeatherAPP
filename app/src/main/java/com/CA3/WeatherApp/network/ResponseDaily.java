package com.CA3.WeatherApp.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Luciana Alves - 18350
 */

public class ResponseDaily {
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("shortDayName")
    @Expose
    private String shortDayName;
    @SerializedName("shortDate")
    @Expose
    private String shortDate;
    @SerializedName("htmlDate")
    @Expose
    private String htmlDate;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("weather")
    @Expose
    private String weather;
    @SerializedName("weatherNumber")
    @Expose
    private String weatherNumber;
    @SerializedName("weatherDescription")
    @Expose
    private String weatherDescription;
    @SerializedName("wind-speed")
    @Expose
    private Integer windSpeed;
    @SerializedName("windDescription")
    @Expose
    private String windDescription;
    @SerializedName("rainfall")
    @Expose
    private String rainfall;
    @SerializedName("wind-direction")
    @Expose
    private String windDirection;
    @SerializedName("temperature")
    @Expose
    private Integer temperature;
    @SerializedName("temperature-class")
    @Expose
    private String temperatureClass;
    @SerializedName("warnings")
    @Expose
    private ResponseWarning warnings;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("appTime")
    @Expose
    private String appTime;
    @SerializedName("canonicalWindDirection")
    @Expose
    private String canonicalWindDirection;
    @SerializedName("dayIndex")
    @Expose
    private Integer dayIndex;
    @SerializedName("dayNumber")
    @Expose
    private Integer dayNumber;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShortDayName() {
        return shortDayName;
    }

    public void setShortDayName(String shortDayName) {
        this.shortDayName = shortDayName;
    }

    public String getShortDate() {
        return shortDate;
    }

    public void setShortDate(String shortDate) {
        this.shortDate = shortDate;
    }

    public String getHtmlDate() {
        return htmlDate;
    }

    public void setHtmlDate(String htmlDate) {
        this.htmlDate = htmlDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherNumber() {
        return weatherNumber;
    }

    public void setWeatherNumber(String weatherNumber) {
        this.weatherNumber = weatherNumber;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDescription() {
        return windDescription;
    }

    public void setWindDescription(String windDescription) {
        this.windDescription = windDescription;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureClass() {
        return temperatureClass;
    }

    public void setTemperatureClass(String temperatureClass) {
        this.temperatureClass = temperatureClass;
    }

    public ResponseWarning getWarnings() {
        return warnings;
    }

    public void setWarnings(ResponseWarning warnings) {
        this.warnings = warnings;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getCanonicalWindDirection() {
        return canonicalWindDirection;
    }

    public void setCanonicalWindDirection(String canonicalWindDirection) {
        this.canonicalWindDirection = canonicalWindDirection;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }
}
