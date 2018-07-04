package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    //@Query("SELECT r FROM Room r ORDER BY r.roomId ASC")
    public List<Room> findAllByOrderByRoomId();
}
