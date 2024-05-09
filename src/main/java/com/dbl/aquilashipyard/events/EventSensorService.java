package com.dbl.aquilashipyard.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class EventSensorService {

    private final Logger logger = LoggerFactory.getLogger(EventSensorService.class);

    private final EventSensorRepository eventSensorRepository;

    public EventSensorService(EventSensorRepository eventSensorRepository) {
        this.eventSensorRepository = eventSensorRepository;
    }

    public EventSensor save(EventSensorDTO eventSensorDTO) {
        logger.info("Saving sensor event");
        EventSensor eventSensor = eventSensorRepository.save(new EventSensor(eventSensorDTO.sensorName, new GeoJsonPoint(eventSensorDTO.coordinates.get(0), eventSensorDTO.coordinates.get(1))));
        logger.info("Sensor Event was saved");
        return eventSensor;
    }

    public EventSensor getEventSensorById(String id) throws Exception {
        logger.info("Searching event sensor by id");
        EventSensor eventSensor = eventSensorRepository.findById(id).orElseThrow(() -> new Exception("Event was not found with id::  " + id));
        logger.info("Event was found");
        return eventSensor;
    }


    public Page<EventSensor> queryByFilters(String sensorName, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {

        startDate = startDate.atOffset(ZoneOffset.UTC).toLocalDateTime();
        endDate = endDate.atOffset(ZoneOffset.UTC).toLocalDateTime();

        //TODO olhar isso.
        if (sensorName.isBlank()) {
            //exec query1 query por data
        } else {
            //sensorName e a data.
        }
        return eventSensorRepository.findByFilters(sensorName, startDate, endDate, pageable);
    }
}
