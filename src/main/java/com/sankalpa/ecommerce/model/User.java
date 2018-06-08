package com.sankalpa.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	String firstName;

	@Column(nullable = false)
	String lastName;

	@Column(nullable = false)
	int dob;
}