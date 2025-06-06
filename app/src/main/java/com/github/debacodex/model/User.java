package com.github.debacodex.model;

 // Make sure this matches your package name

public class User {
	public String name;
	public String email;
	
	// Default constructor required for calls to DataSnapshot.getValue(User.class)
	public User() {
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	// You can also add getters if you prefer, though Firebase doesn't strictly need them for writing
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
}