package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.model.Event;
import com.sankalpa.ictc_events.service.AdminService;
import com.sankalpa.ictc_events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @Autowired
//    private EventService eventService;

    @GetMapping("/admins")
    public @ResponseBody List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{adminId}")
    public @ResponseBody Admin getAdmin(@PathVariable Long adminId){
        return adminService.getAdmin(adminId);
    }

    @PostMapping("/admins")
    public @ResponseBody Admin addAdmin(@RequestBody Admin newAdmin){
        return adminService.addAdmin(newAdmin);
    }

    @PutMapping("/admins")
    public @ResponseBody Admin updateAdmin(@RequestBody Admin updatedAdmin){
        return adminService.updateAdmin(updatedAdmin);
    }

    @DeleteMapping("/admins/{adminId}")
    public void deleteAdmin(@PathVariable Long adminId){
        adminService.deleteAdmin(adminId);
    }

//    @GetMapping("/admins/{adminId}/events")
//    public List<Event> getAllEvents(@PathVariable Long adminId){
//        // here we used 'eventService' instead of 'adminService'
//        return eventService.getAllEvents(adminId);
//    }

//    @PutMapping("/admins/{adminId}/events/{eventId}")
//    public void approveEvent(@PathVariable Long adminId, @PathVariable Long eventId){
//        adminService.approveEvent(eventId, adminId);
//    }
}
