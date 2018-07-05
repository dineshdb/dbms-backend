package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.service.AdminService;
import com.sankalpa.ictc_events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EventService eventService;

    @GetMapping("/admins")
    public @ResponseBody List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{adminId}")
    public @ResponseBody Admin getAdmin(@PathVariable Long adminId){
        return adminService.getAdmin(adminId);
    }

    @PostMapping("/admins")
    public void addAdmin(@RequestBody Admin newAdmin){
        adminService.addAdmin(newAdmin);
    }

    @PutMapping("/admins/{adminId}")
    public void updateAdmin(@RequestBody Admin updatedAdmin, @PathVariable Long adminId){
        adminService.updateAdmin(adminId, updatedAdmin);
    }

    @DeleteMapping("/admins/{adminId}")
    public void deleteAdmin(@PathVariable Long adminId){
        adminService.deleteAdmin(adminId);
    }

    @GetMapping("/admins/{adminId}/events")
    public List<Event> getAllEvents(@PathVariable Long adminId){
        // here we used 'eventService' instead of 'adminService'
        return eventService.getAllEvents(adminId);
    }

    @PutMapping("/admins/{adminId}/events/{eventId}")
    public void approveEvent(@PathVariable Long adminId, @PathVariable Long eventId){
        adminService.approveEvent(eventId, adminId);
    }
}
