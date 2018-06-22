package com.sankalpa.ictc_events.model;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type" )
public class User {
	@Id
	@GeneratedValue
	private Long id;
	String name;
}