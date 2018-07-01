package com.sankalpa.ictc_events.model;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@Table(name = "users")
@DiscriminatorColumn( name = "userRole")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String userPassword;

	public User(){}

	public User(String userName, String userPassword){
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Transient
	public String getDiscriminatorValue(){
		DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

		return val == null ? null : val.value();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
