package com.fuego.quasar.api.service.implementation;

import com.fuego.quasar.api.service.ISatelliteService;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

@Service
public class SatelliteService implements ISatelliteService {

    private Map<String, Point2D.Double> validSatellites;

    public SatelliteService(){
        super();

        validSatellites = new HashMap<>();
        validSatellites.put("kenobi", new Point2D.Double(-500.0,-200.0));
        validSatellites.put("skywalker", new Point2D.Double(100.0,-100.0));
        validSatellites.put("sato", new Point2D.Double(500.0,100.0));
    }

    @Override
    public Point2D getLocation(double... distances) {
        double x1,x2,x3;
        double y1,y2,y3;
        double r1,r2,r3;

        x1=this.validSatellites.get("kenobi").getX();
        y1=this.validSatellites.get("kenobi").getY();
        x2=this.validSatellites.get("skywalker").getX();
        y2=this.validSatellites.get("skywalker").getY();
        x3=this.validSatellites.get("sato").getX();
        y3=this.validSatellites.get("sato").getY();

        r1=distances[0];
        r2=distances[1];
        r3=distances[2];

        double x =( ( y2-y3 )*( ( y2*y2-y1*y1 )+( x2*x2-x1*x1 )+( r1*r1-r2*r2 ) ) - ( y1-y2 ) * ( ( y3*y3-y2*y2 ) + ( x3*x3-x2*x2 )+( r2*r2-r3*r3 ) ) ) / ( 2 * ( (x1-x2)*(y2-y3)-(x2-x3)*(y1-y2) ) );

        double y =( ( x2-x3 )*( ( x2*x2-x1*x1 )+( y2*y2-y1*y1 )+( r1*r1-r2*r2 ) ) - ( x1-x2 ) * ( ( x3*x3-x2*x2 ) + ( y3*y3-y2*y2 )+( r2*r2-r3*r3 ) ) ) / ( 2 * ( (y1-y2)*(x2-x3)-(y2-y3)*(x1-x2) ) );

        return new Point2D.Double(x,y);
    }

    @Override
    public String getMessage(String[]... messages) {
        int maxLength = Integer.MIN_VALUE;
        int delta;
        String [] out;
        StringBuilder outMessage = new StringBuilder();

        for(String [] message: messages){
            if(message.length > maxLength){
                maxLength = message.length;
            }
        }

        out = new String [maxLength];
        for(int i=0;i<maxLength;i++){
            out[i] = "";
            for(String [] message: messages){
                delta = maxLength - message.length;
                if(i >= delta && !message[i-delta].equals("")){
                    out[i] = message[i-delta];
                }
            }
        }

        for(String token: out){
            outMessage.append(token);
            outMessage.append(" ");
        }

        return outMessage.toString().trim();
    }

    @Override
    public Map<String, Point2D.Double> getValidSatellites() {
        return validSatellites;
    }
}
