package com.cifop.tn.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cifop.tn.entities.ClassRoom;
import com.cifop.tn.entities.Student;
import com.cifop.tn.services.ClassRoomServices;
import com.cifop.tn.services.StudentServices;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named // dependancy injection
@SessionScoped // contexte scope
public class StudentController implements Serializable {

	@Inject
	StudentServices studentServices;

	@Inject
	ClassRoomServices classRoomServices;

	@Inject
	FacesContext facesContext;

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String adress;

	private String classRoomName;
	private String classRoomNameSearch ;

	public void doCreateStudent() {

		ClassRoom classRoom = classRoomServices.findClassRoomByNameCreateQuery(classRoomName);
		Student studentToAdd = new Student(firstName, lastName, adress, dateOfBirth, classRoomName);

		studentServices.addStudent(studentToAdd);
		classRoomServices.addStudentToClassroom(studentToAdd, classRoom);

		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Student is saved successfully"));

//		ClassRoom classRoom = classRoomServices.findClassRoomByNameCreateQuery(classRoomName);
//		classRoomServices.addStudentToClassroom(studentToAdd, classRoom);
//		studentServices.addStudent(studentToAdd);

	}

	public List<String> doListClassroomName() {

		List<String> names = new ArrayList<String>();
		List<ClassRoom> classRooms = classRoomServices.findAllClassRooms();
		for (ClassRoom classRoom : classRooms) {
			names.add(classRoom.getName());

		}
		return names;

	}

	public List<Student> doListStudents() {

		return studentServices.findAllStudents();
	}

	public String doGetClassRoomNameByNameStudent() {
		return classRoomServices.findClassroomNameByFirstNameStudentCreateQuery(firstName);

	}

	public List<Student> doGetListStudentsByClassRoomName() {
			return studentServices.findListStudentByClassroomName(classRoomNameSearch);
		
	
	}

	public String getClassRoomName(ClassRoom classRoom) {
		return classRoom.getName();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getClassRoomName() {
		return classRoomName;
	}

	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}

	public String getClassRoomNameSearch() {
		return classRoomNameSearch;
	}

	public void setClassRoomNameSearch(String classRoomNameSearch) {
		this.classRoomNameSearch = classRoomNameSearch;
	}

}
