package com.sankalpa.ictc_events;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// TODO: replace this file with sql files data.sql and schema.sql with 'spring.jpa.hibernate.ddl-auto=none'

@Component
public class LoadDatabase implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
        adminRepository.save(new Admin("admin", "ict123"));
    }
}
