package com.api.book.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String firstname;
private String lastname;
private String language;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}

}
