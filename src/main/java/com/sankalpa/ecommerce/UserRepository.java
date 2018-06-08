package com.sankalpa.ecommerce;

import com.sankalpa.ecommerce.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserById(Long id);
}
