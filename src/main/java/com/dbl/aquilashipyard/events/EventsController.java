package com.dbl.aquilashipyard.events;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/events")
public class EventsController {

    private final EventSensorService eventSensorService;

    public EventsController(EventSensorService eventSensorService) {
        this.eventSensorService = eventSensorService;
    }

    @PostMapping
    public EventSensorDTO persistEvent(@RequestBody EventSensorDTO eventSensorDTO) {
        EventSensor eventSensor = eventSensorService.save(eventSensorDTO);
        return new EventSensorDTO(
                eventSensor.sensorName,
                eventSensor.geoJsonPoint.getCoordinates()
        );
    }


    @GetMapping("/{id}")
    public EventSensorDTO getEvent(@PathVariable("id") String id) throws Exception {
        EventSensor eventSensor = eventSensorService.getEventSensorById(id);
        return new EventSensorDTO(
                eventSensor.sensorName,
                eventSensor.geoJsonPoint.getCoordinates()
        );
    }

}
