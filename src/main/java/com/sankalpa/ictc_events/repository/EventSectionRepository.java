package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.EventSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSectionRepository extends CrudRepository<EventSection, Long> {
}
