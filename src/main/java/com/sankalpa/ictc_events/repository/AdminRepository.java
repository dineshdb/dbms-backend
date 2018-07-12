package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: make everthing in repository form MySQL commands
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
