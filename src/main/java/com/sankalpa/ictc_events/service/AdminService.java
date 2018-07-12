package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.repository.AdminRepository;
import com.sankalpa.ictc_events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    // TODO: make admin repository connect to only User table
    @Autowired
    private AdminRepository adminRepository;

//    @Autowired
//    private EventService eventService;

    public List<Admin> getAllAdmins(){
        List<Admin> admins = new ArrayList<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    public Admin updateAdmin(Admin updatedAdmin){
        return adminRepository.save(updatedAdmin);
    }

    public Admin addAdmin(Admin newAdmin){
        return adminRepository.save(newAdmin);
    }

    public void deleteAdmin(Long adminId){
        adminRepository.deleteById(adminId);
    }

    public Admin getAdmin(Long adminId){
        return adminRepository.findById(adminId).orElse(null);
    }


    // TODO: no need to approve event as admin is the only user controlling the events;
//    public void approveEvent(Long eventId, Long adminId) {
//
//        Admin admin = getAdmin(adminId);
//        Event event = eventService.getEvent(eventId);
//
//        event.setAccepted(1);
//        event.setAdmin(admin);
//
//        eventService.updateEvent(eventId, event);
//    }
}
