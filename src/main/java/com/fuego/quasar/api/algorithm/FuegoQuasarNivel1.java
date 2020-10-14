package com.fuego.quasar.api.algorithm;

import java.awt.geom.Point2D;

public class FuegoQuasarNivel1 {
    private Point2D kenobi;
    private Point2D skywalker ;
    private Point2D sato;

    public FuegoQuasarNivel1(){
        super();
        this.kenobi = new Point2D.Double(-500.0,-200.0);
        this.skywalker  = new Point2D.Double(100.0,-100.0);
        this.sato = new Point2D.Double(500.0,100.0);
    }

    public static void main(String[] args){
        FuegoQuasarNivel1 obj = new FuegoQuasarNivel1();
        Point2D location;

        location = obj.getLocation(10f, 15f, 8f);

        System.out.println("X:"+location.getX()+" Y:"+location.getY());

        String [] m1 = {"", "este", "es", "un", "mensaje"}
                 ,m2 = {"este", "", "un", "mensaje"}
                 ,m3 = {"", "", "es", "", "mensaje"};

        System.out.println("Message:"+obj.getMessage(m1, m2, m3));
    }

    private Point2D getLocation(float... distances){
        double x1,x2,x3;
        double y1,y2,y3;
        double r1,r2,r3;

        x1=this.kenobi.getX();
        y1=this.kenobi.getY();
        x2=this.skywalker.getX();
        y2=this.skywalker.getY();
        x3=this.sato.getX();
        y3=this.sato.getY();

        r1=distances[0];
        r2=distances[1];
        r3=distances[2];

        double x =( ( y2-y3 )*( ( y2*y2-y1*y1 )+( x2*x2-x1*x1 )+( r1*r1-r2*r2 ) ) - ( y1-y2 ) * ( ( y3*y3-y2*y2 ) + ( x3*x3-x2*x2 )+( r2*r2-r3*r3 ) ) ) / ( 2 * ( (x1-x2)*(y2-y3)-(x2-x3)*(y1-y2) ) );

        double y =( ( x2-x3 )*( ( x2*x2-x1*x1 )+( y2*y2-y1*y1 )+( r1*r1-r2*r2 ) ) - ( x1-x2 ) * ( ( x3*x3-x2*x2 ) + ( y3*y3-y2*y2 )+( r2*r2-r3*r3 ) ) ) / ( 2 * ( (y1-y2)*(x2-x3)-(y2-y3)*(x1-x2) ) );

        return new Point2D.Double(x,y);
    }

    private String getMessage(String []... messages){
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
}
