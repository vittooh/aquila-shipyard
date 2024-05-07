package com.dbl.aquilashipyard.events;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSensorRepository extends MongoRepository<EventSensor, String> {

}