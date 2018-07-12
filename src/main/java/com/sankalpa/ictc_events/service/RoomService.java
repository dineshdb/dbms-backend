package com.sankalpa.ictc_events.service;

import com.sankalpa.ictc_events.model.Room;
import com.sankalpa.ictc_events.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<Room>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    public Room getRoom(Long roomId){
        return roomRepository.findById(roomId).orElse(null);
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public Room updateRoom(Room updatedRoom){
        return roomRepository.save(updatedRoom);
    }

    public void deleteRoom(Long roomId){
        roomRepository.deleteById(roomId);
    }

    public List<Room> getAllRoomsInOrder() {
        return roomRepository.findAllByOrderByRoomId();
    }
}
