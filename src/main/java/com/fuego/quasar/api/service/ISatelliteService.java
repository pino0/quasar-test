package com.fuego.quasar.api.service;

import java.awt.geom.Point2D;
import java.util.Map;

public interface ISatelliteService {

   Point2D getLocation(double... distances);

   String getMessage(String []... messages);

   Map<String, Point2D.Double> getValidSatellites();
}
