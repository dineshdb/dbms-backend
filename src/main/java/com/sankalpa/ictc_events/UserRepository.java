package com.sankalpa.ictc_events;

import com.sankalpa.ictc_events.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserById(Long id);
}
