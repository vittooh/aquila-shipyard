package com.dbl.aquilashipyard.events;

import java.util.ArrayList;
import java.util.List;

public class EventSensorDTO {
    public String sensorName;
    public List<Double> coordinates;

    public EventSensorDTO() {
    }

    public EventSensorDTO(String sensorName, List<Double> coordinates) {
        this.sensorName = sensorName;
        this.coordinates = coordinates;
    }
}
