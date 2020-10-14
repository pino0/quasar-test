package com.fuego.quasar.api.dto;

import java.io.Serializable;

public class SatelliteDto implements Serializable {

    private String name;
    private double distance;
    private String [] message;

    public SatelliteDto(){
        super();
    }

    public SatelliteDto(String name, double distance, String [] message){
        super();
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public String[] getMessage() {
        return message;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("{ name: "+ name + ", distance: "+ distance + ", message: [");
        for(String token : message){
            out.append(token+", ");
        }
        out.append("]}");

        return out.toString();
    }
}
