package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    public List<Event> findByAdminUserId(Long adminId);
    public List<Event> findByOrganizerUserId(Long organizerId);
}
