package com.dbl.aquilashipyard.events;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventSensorRepository extends MongoRepository<EventSensor, String> {


    @Query("{ 'sensorName': ?0, 'createDate': { '$gte': ?1, '$lte': ?2 } }")
    Page<EventSensor> findByFiltersAndName(String sensorName, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    @Query("{'createDate': { '$gte': ?0, '$lte': ?1 } }")
    Page<EventSensor> findByFilters(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}