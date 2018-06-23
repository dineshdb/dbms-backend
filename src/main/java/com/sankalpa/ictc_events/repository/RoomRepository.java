package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
