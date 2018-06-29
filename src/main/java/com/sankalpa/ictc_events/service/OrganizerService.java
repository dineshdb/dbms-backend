package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.Organizer;
import com.sankalpa.ictc_events.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizerService {

    // TODO: make organizer repository connect to only user table
    @Autowired
    private OrganizerRepository organizerRepository;

    public List<Organizer> getAllOrganizers(){
        List<Organizer> organizers = new ArrayList<Organizer>();
        organizerRepository.findAll().forEach(organizers::add);
        return organizers;
    }

    public void updateOrganizer(Long organizerId, Organizer updatedOrganizer){
        organizerRepository.save(updatedOrganizer);
    }

    public void addOrganizer(Organizer newOrganizer){
        organizerRepository.save(newOrganizer);
    }

    public void deleteOrganizer(Long organizerId){
        organizerRepository.deleteById(organizerId);
    }

    public Organizer getOrganizer(Long organizerId){
        return organizerRepository.findById(organizerId).orElse(null);
    }
}
