package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.EventSection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.cert.LDAPCertStoreParameters;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface EventSectionRepository extends CrudRepository<EventSection, Long>{

    //@Query("SELECT e FROM EventSection e WHERE e.eventSectionDate LIKE CONCAT('%', ':date', '%')")
    public List<EventSection> findByeventSectionDate(LocalDate date);
}
