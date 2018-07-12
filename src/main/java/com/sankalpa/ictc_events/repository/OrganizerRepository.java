package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
