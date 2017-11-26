package com.example.ilman.weatherapp2.model;

/**
 * Created by ilman on 26/11/2017.
 */

public class WeatherList {
    String time;
    Double tempMax;
    Double tempMin;
    String status;

    public WeatherList(String time, Double tempMax, Double tempMin, String status) {
        this.time = time;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
