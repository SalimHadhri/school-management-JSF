package com.cifop.tn.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// @Column(name = "ismik")
	private String firstName;

	private String lastName;
	private String adress;

	@Temporal(TemporalType.DATE)
	private Date dateOfeBirth;
	
	

	public Student() {
	}

	public Student(long id, String firstName, String lastName, String adress, Date dateOfeBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.dateOfeBirth = dateOfeBirth;
	}

	public Student(String firstName, String lastName, String adress, Date dateOfeBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.dateOfeBirth = dateOfeBirth;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDateOfeBirth() {
		return dateOfeBirth;
	}

	public void setDateOfeBirth(Date dateOfeBirth) {
		this.dateOfeBirth = dateOfeBirth;
	}

	public long getId() {
		return id;
	}

}
