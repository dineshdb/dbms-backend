package com.sankalpa.ictc_events.controller;

import com.sankalpa.ictc_events.model.Room;
import com.sankalpa.ictc_events.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public @ResponseBody List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{roomId}")
    public @ResponseBody Room getRoom(@PathVariable Long roomId){
        return roomService.getRoom(roomId);
    }

    @PostMapping("/rooms")
    public void addRoom(@RequestBody Room newRoom){
        roomService.addRoom(newRoom);
    }

    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoom(@PathVariable Long roomId){
        roomService.deleteRoom(roomId);
    }

    @PutMapping("/rooms/{roomId}")
    public void updateRoom(@RequestBody Room updatedRoom,
                           @PathVariable Long roomId){
        roomService.updateRoom(roomId, updatedRoom);
    }

    @GetMapping("/roomsInOrder")
    public @ResponseBody List<Room> getAllRoomsInOrder(){
        return roomService.getAllRoomsInOrder();
    }
}
