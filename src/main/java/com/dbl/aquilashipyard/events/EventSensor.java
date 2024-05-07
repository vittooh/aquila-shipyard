package com.dbl.aquilashipyard.events;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("event-sensors")
public class EventSensor {

    @Id
    String id;

    public String sensorName;

    public GeoJsonPoint geoJsonPoint;


    public EventSensor(String sensorName, GeoJsonPoint geoJsonPoint) {
        this.sensorName = sensorName;
        this.geoJsonPoint = geoJsonPoint;
    }
}
