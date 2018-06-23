package com.sankalpa.ictc_events.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class Admin extends User {

    public Admin() {
    }

    public Admin(Long userId, String userName, String userPassword) {
        super(userId, userName, userPassword);
    }
}
