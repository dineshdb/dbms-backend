package com.sankalpa.ictc_events.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "ADMIN")
public class Admin extends User {

    public Admin() {
    }

    public Admin(String userName, String userPassword) {
        super(userName, userPassword);
    }
}
