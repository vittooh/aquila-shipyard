package com.dbl.aquilashipyard.events;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/events")
public class EventsController {

    private final EventSensorService eventSensorService;

    public EventsController(EventSensorService eventSensorService) {
        this.eventSensorService = eventSensorService;
    }

    @PostMapping
    @Operation(description = "Endpoint to receive a sensor event and store on the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sensor event was saved"),
                    @ApiResponse(responseCode = "500", description = "Something wrong happened when saving sensor event")
            }
    )
    public EventSensorDTO persistEvent(@RequestBody EventSensorDTO eventSensorDTO) {
        EventSensor eventSensor = eventSensorService.save(eventSensorDTO);
        return new EventSensorDTO(
                eventSensor.id,
                eventSensor.sensorName,
                eventSensor.geoJsonPoint.getCoordinates()
        );
    }


    @GetMapping("/{id}")
    @Operation(description = "Endpoint for retrieve sensor event by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Event Sensor was retrieve"),
                    @ApiResponse(responseCode = "500", description = "Something wrong happened when retrieving the sensor event")
            }
    )
    public EventSensorDTO getEvent(@PathVariable("id") String id) throws Exception {
        EventSensor eventSensor = eventSensorService.getEventSensorById(id);
        return new EventSensorDTO(
                eventSensor.id,
                eventSensor.sensorName,
                eventSensor.geoJsonPoint.getCoordinates()
        );
    }

    @GetMapping("/query")
    public Page<EventSensorDTO> getEventsSensorByFilter(
            @RequestParam(value = "sensorName", required = false) String sensorName,
            @RequestParam(value = "startDate") LocalDateTime startDate,
            @RequestParam(value = "endDate") LocalDateTime endDate,
            @PageableDefault Pageable pageable
    ) {

        if (startDate == null) {
            startDate = LocalDateTime.now();
        }

        if (endDate == null) {
            endDate = LocalDateTime.now();
        }

        Page<EventSensor> eventSensorList =
                eventSensorService.queryByFilters(sensorName, startDate, endDate, pageable);

        List<EventSensorDTO> events = eventSensorList.getContent().stream().map(
                eventSensor -> new EventSensorDTO(
                        eventSensor.id,
                        eventSensor.sensorName,
                        eventSensor.geoJsonPoint.getCoordinates()
                )
        ).toList();

        return new PageImpl<>(
                events, eventSensorList.getPageable(), events.size()
        );
    }
}
