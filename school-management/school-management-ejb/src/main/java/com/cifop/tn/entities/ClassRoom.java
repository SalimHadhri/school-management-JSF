package com.cifop.tn.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "ClassRoom")
@NamedQuery(name = "findListStudentByClassRoomName", query = "select c from Student c where c.classRoomName = :classRoomName")
@NamedQuery(name = "findClassRoomByName", query = "select c from ClassRoom c where c.name = :classRoomName")
@NamedQuery(name = "findClassRoomByIdStudent", query = "select c from ClassRoom c where :student in (c.students)")
public class ClassRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String grade;
	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Student> students;

	

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public ClassRoom(long id, String grade, String name, List<Student> students) {
		this.id = id;
		this.grade = grade;
		this.name = name;
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", grade=" + grade + ", name=" + name + ", students=" + students + "]";
	}

	public ClassRoom(String grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	public ClassRoom() {
	}

	
	
}
