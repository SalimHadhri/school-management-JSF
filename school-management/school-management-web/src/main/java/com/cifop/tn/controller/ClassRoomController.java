package com.cifop.tn.controller;

import java.io.Serializable;

import com.cifop.tn.entities.ClassRoom;
import com.cifop.tn.services.ClassRoomServices;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/*
 * backing bean
 */
@Named // dependancy injection
@SessionScoped // contexte scope
public class ClassRoomController implements Serializable {

	@Inject
	ClassRoomServices classRoomServices;

	@Inject
	FacesContext facesContext ;
	
	//parametres
	private String grade;
	private String name;

	public void doCreateClassRoom() {
		
		
		classRoomServices.addClassRoom(new ClassRoom(grade, name));
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO","ClassRoom is saved successfully"));
		System.out.println("doCreateClassRoom called");
	}

	
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
