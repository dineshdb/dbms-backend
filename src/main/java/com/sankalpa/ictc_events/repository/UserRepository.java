package com.sankalpa.ictc_events.repository;

import com.sankalpa.ictc_events.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
