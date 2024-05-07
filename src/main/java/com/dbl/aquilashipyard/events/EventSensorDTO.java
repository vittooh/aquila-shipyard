package com.dbl.aquilashipyard.events;

import java.util.ArrayList;
import java.util.List;

public class EventSensorDTO {

    public String id;
    public String sensorName;
    public List<Double> coordinates;

    public EventSensorDTO() {
    }

    public EventSensorDTO(String sensorName, List<Double> coordinates) {
        this.sensorName = sensorName;
        this.coordinates = coordinates;
    }

    public EventSensorDTO(String id, String sensorName, List<Double> coordinates) {
        this.id = id;
        this.sensorName = sensorName;
        this.coordinates = coordinates;
    }
}
