package com.dbl.aquilashipyard.events;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

@Service
public class EventSensorService {

    private final EventSensorRepository eventSensorRepository;

    public EventSensorService(EventSensorRepository eventSensorRepository) {
        this.eventSensorRepository = eventSensorRepository;
    }

    public EventSensor save(EventSensorDTO eventSensorDTO) {
        // long, then lat
        return eventSensorRepository.save(
                new EventSensor(
                        eventSensorDTO.sensorName,
                        new GeoJsonPoint(
                                eventSensorDTO.coordinates.get(0),
                                eventSensorDTO.coordinates.get(1)
                        )
                )
        );
    }

    public EventSensor getEventSensorById(String id) throws Exception {
        return eventSensorRepository.findById("id").orElseThrow(
                () -> new Exception("Deu ruim no id " + id)
        );
    }
}
