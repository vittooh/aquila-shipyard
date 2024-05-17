package com.dbl.aquilashipyard.events;

import java.time.LocalDateTime;

public class EventSearchRequest {
    public String sensorName;
    public LocalDateTime startDate;

    public LocalDateTime endDate;

    public EventSearchRequest(String sensorName, LocalDateTime startDate, LocalDateTime endDate) {
        this.sensorName = sensorName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EventSearchRequest() {
        this.startDate = LocalDateTime.now();
        this.endDate = LocalDateTime.now();
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
