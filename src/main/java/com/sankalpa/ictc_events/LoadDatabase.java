package com.sankalpa.ictc_events;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.model.Room;
import com.sankalpa.ictc_events.repository.AdminRepository;
import com.sankalpa.ictc_events.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// TODO: replace this file with sql files data.sql and schema.sql with 'spring.jpa.hibernate.ddl-auto=none'

@Component
public class LoadDatabase implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        // default admin
        adminRepository.save(new Admin("admin", "ict123"));

        roomRepository.save(new Room("Conference", 45, 0, "Conference", 10500, 1500, 0));
        roomRepository.save(new Room("Meeting Room", 45, 0, "Meeting", 5000, 1000, 0));
        roomRepository.save(new Room("Cafeteria", 30, 0, "Cafeteria", 5600, 800, 0));

        roomRepository.save(new Room("Lecture 1", 50, 1, "Lecture", 10500, 1500, 0));
        roomRepository.save(new Room("Lecture 2", 50, 1, "Lecture", 10500, 1500, 0));
        roomRepository.save(new Room("Lecture 3", 50, 1, "Lecture", 10500, 1500, 0));
        roomRepository.save(new Room("Lecture 4", 50, 1, "Lecture", 10500, 1500, 0));

        roomRepository.save(new Room("Computer 1", 30, 2, "Computer", 18000, 0, 600));
        roomRepository.save(new Room("Computer 2", 30, 2, "Computer", 18000, 0, 600));
        roomRepository.save(new Room("Computer 3", 30, 2, "Computer", 18000, 0, 600));
        roomRepository.save(new Room("Computer 4", 30, 2, "Computer", 18000, 0, 600));

        roomRepository.save(new Room("Computer 5", 30, 3, "Computer", 18000, 0, 600));
        roomRepository.save(new Room("Computer 6", 30, 3, "Computer", 18000, 0, 600));


        roomRepository.save(new Room("Seminar 1", 60, 4, "Seminar", 7500, 1200, 0));
        roomRepository.save(new Room("Seminar 2", 60, 4, "Seminar", 7500, 1200, 0));

    }
}
