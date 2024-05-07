package com.dbl.aquilashipyard.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

@Service
public class EventSensorService {

    private final Logger logger = LoggerFactory.getLogger(EventSensorService.class);

    private final EventSensorRepository eventSensorRepository;

    public EventSensorService(EventSensorRepository eventSensorRepository) {
        this.eventSensorRepository = eventSensorRepository;
    }

    public EventSensor save(EventSensorDTO eventSensorDTO) {
        logger.info("Saving sensor event");
        // long, then lat
        EventSensor eventSensor=  eventSensorRepository.save(
                new EventSensor(
                        eventSensorDTO.sensorName,
                        new GeoJsonPoint(
                                eventSensorDTO.coordinates.get(0),
                                eventSensorDTO.coordinates.get(1)
                        )
                )
        );
        logger.info("Sensor Event was saved");
        return eventSensor;
    }

    public EventSensor getEventSensorById(String id) throws Exception {
        logger.info("Searching event sensor by id");
        EventSensor eventSensor =  eventSensorRepository.findById(id).orElseThrow(
                () -> new Exception("Event was not found with id::  " + id)
        );
        logger.info("Event was found");
        return eventSensor;
    }
}
