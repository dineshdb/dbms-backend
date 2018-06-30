package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.Admin;
import com.sankalpa.ictc_events.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

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
}
