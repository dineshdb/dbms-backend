package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
