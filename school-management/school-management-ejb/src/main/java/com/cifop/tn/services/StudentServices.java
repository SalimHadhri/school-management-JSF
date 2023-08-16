package com.cifop.tn.services;

import java.util.ArrayList;
import java.util.List;

import com.cifop.tn.entities.ClassRoom;
import com.cifop.tn.entities.Student;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateful
public class StudentServices {

	@PersistenceContext
	EntityManager entityManager;

	//ClassRoomServices classRoomServices;
	
	

	public void addStudent(Student student) {
		entityManager.persist(student);
	}

	public Student updateStudent(Student student) {

		return entityManager.merge(student);
	}

	public Student findStudentById(long id) {

		return entityManager.find(Student.class, id);
	}

	public List<Student> findAllStudents() {

		return entityManager.createQuery("select s from Student s").getResultList();
	}

	public void removeStudent(Student student) {
		entityManager.remove(student);
	}

	// create query to find a list of student by firstname
	// createQuery
	public List<Student> findStudentByFirstname(String firstNameSearching) {

		return entityManager.createQuery("select s from Student s where s.firstName = ?1")
				.setParameter(1, firstNameSearching).getResultList();
	}

	// create query to find a list of student by classroomName
	// namedQuery
	public List<Student> findListStudentByClassroomName(String classRoomName) {

		return  entityManager.createNamedQuery("findListStudentByClassRoomName")
				.setParameter("classRoomName", classRoomName).getResultList();
		
	}

//	public void addStudentUpdateClassroom(Student student, ClassRoom classRoom) {
//		entityManager.persist(student);
//		classRoomServices.addStudentToClassroom(student, classRoom);
//	}

}
