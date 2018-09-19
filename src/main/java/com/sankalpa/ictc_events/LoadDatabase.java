package com.sankalpa.ictc_events;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.model.Organizer;
import com.sankalpa.ictc_events.model.Room;
import com.sankalpa.ictc_events.repository.AdminRepository;
import com.sankalpa.ictc_events.repository.EventRepository;
import com.sankalpa.ictc_events.repository.OrganizerRepository;
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
//
//    @Autowired
//    private OrganizerRepository organizerRepository;
//
//    @Autowired
//    private EventRepository eventRepository;

    @Override
    public void run(String... args) throws Exception {

        // default admin
//        adminRepository.save(new Admin("admin", "ict123"));
//
//
//        // rooms
//        roomRepository.save(new Room("Conference", 45, 0, "Conference", 10500, 1500, 0));
//        roomRepository.save(new Room("Meeting Room", 45, 0, "Meeting", 5000, 1000, 0));
//        roomRepository.save(new Room("Cafeteria", 30, 0, "Cafeteria", 5600, 800, 0));
//
//        roomRepository.save(new Room("Lecture 1", 50, 1, "Lecture", 10500, 1500, 0));
//        roomRepository.save(new Room("Lecture 2", 50, 1, "Lecture", 10500, 1500, 0));
//        roomRepository.save(new Room("Lecture 3", 50, 1, "Lecture", 10500, 1500, 0));
//        roomRepository.save(new Room("Lecture 4", 50, 1, "Lecture", 10500, 1500, 0));
//
//        roomRepository.save(new Room("Computer 1", 30, 2, "Computer", 18000, 0, 600));
//        roomRepository.save(new Room("Computer 2", 30, 2, "Computer", 18000, 0, 600));
//        roomRepository.save(new Room("Computer 3", 30, 2, "Computer", 18000, 0, 600));
//        roomRepository.save(new Room("Computer 4", 30, 2, "Computer", 18000, 0, 600));
//
//        roomRepository.save(new Room("Computer 5", 30, 3, "Computer", 18000, 0, 600));
//        roomRepository.save(new Room("Computer 6", 30, 3, "Computer", 18000, 0, 600));
//        roomRepository.save(new Room("Language Lab 7", 30, 3, "Computer", 14000, 2000, 0));
//        roomRepository.save(new Room("Computer 8", 30, 3, "Computer", 18000, 0, 600));
//
//        roomRepository.save(new Room("Seminar 1", 60, 4, "Seminar", 7500, 1200, 0));
//        roomRepository.save(new Room("Seminar 2", 60, 4, "Seminar", 7500, 1200, 0));

//        // organizers
//        organizerRepository.save(new Organizer("bhusal", "bhusal505", "Anish Bhusal",
//                "bhusal@anish.com", "Buddhanagar", "9845327392"));
//
//        // events
//        eventRepository.save(new Event("Big Data Workshop", "An introduction to big data and its application", 60, 3, 0));
//        eventRepository.save(new Event("KiCAD Training", "An indepth intro to KiCAD", 50, 1, 0));
//        eventRepository.save(new Event("NMB Exam", "Examination", 100, 1, 0));
//        eventRepository.save(new Event("DBMS", "Lecture class for DBMS", 48, 1, 0));

    }
}
