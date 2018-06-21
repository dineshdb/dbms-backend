package com.sankalpa.ictc_events.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue( value="ORG" )
public class Organizer extends User{
}
