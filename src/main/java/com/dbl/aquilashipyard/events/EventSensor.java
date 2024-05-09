package com.dbl.aquilashipyard.events;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("event-sensors")
public class EventSensor {

    @Id
    public String id;

    public String sensorName;

    public GeoJsonPoint geoJsonPoint;

    @CreatedDate
    @Field("createDate")
    public LocalDateTime createDate;


    public EventSensor(String sensorName, GeoJsonPoint geoJsonPoint) {
        this.sensorName = sensorName;
        this.geoJsonPoint = geoJsonPoint;
    }
}
