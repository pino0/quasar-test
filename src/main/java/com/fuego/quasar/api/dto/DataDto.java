package com.fuego.quasar.api.dto;

import java.awt.geom.Point2D;
import java.io.Serializable;


public class DataDto implements Serializable {


    private Point2D position;
    private String message;

    public DataDto(){
        super();
    }

    public DataDto(double x, double y, String message){
        super();
        this.position = new Point2D.Double(x,y);
        this.message = message;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{ position: { x : " + position.getY() + ", y: " + position.getY() + "}, "
                + "message: " + message +"}";
    }
}
