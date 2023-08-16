package com.cifop.tn.services;

import java.util.List;

import com.cifop.tn.entities.ClassRoom;
import com.cifop.tn.entities.Student;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateful
public class ClassRoomServices {

	@PersistenceContext
	EntityManager entityManager;

	StudentServices studentServices;

	// createQuery method
	public ClassRoom findClassRoomByNameCreateQuery(String classRoomName) {
		return (ClassRoom) entityManager.createQuery("select c from ClassRoom c where c.name = ?1")
				.setParameter(1, classRoomName).getSingleResult();

	}

	// namedQuery method
	public ClassRoom findClassRoomByNameNamedQuery(String classRoomName) {
		return (ClassRoom) entityManager.createNamedQuery("findClassRoomByName")
				.setParameter("classRoomName", classRoomName).getSingleResult();

	}

	// createQuery method
	public ClassRoom findClassroomByIdStudentCreateQuery(long idStudent) {

		Student student = studentServices.findStudentById(idStudent);
		return (ClassRoom) entityManager.createQuery("select c from ClassRoom c where ?1 in c.students")
				.setParameter(1, student).getSingleResult();

	}

	// namedQuery method
	public ClassRoom findClassRoomByIdStudentNamedQuery(long idStudent) {
		Student student = studentServices.findStudentById(idStudent);
		return (ClassRoom) entityManager.createNamedQuery("findClassRoomByIdStudent").setParameter("student", student)
				.getSingleResult();

	}

	public List<Student> findListStudentsByClassRoomName(String classRoomName) {
		ClassRoom classRoom = findClassRoomByNameCreateQuery(classRoomName);
		return classRoom.getStudents();

	}

	public void addClassRoom(ClassRoom classRoom) {
		entityManager.persist(classRoom);
	}

	public void addStudentToClassroom(Student student, ClassRoom classRoom) {
		List<Student> list = classRoom.getStudents() ;
		list.add(student) ;
		classRoom.setStudents(list); 
		entityManager.merge(classRoom);
	}

	public List<ClassRoom> findAllClassRooms() {

		return entityManager.createQuery("select s from ClassRoom s").getResultList();
	}

}
