package com.cifop.tn;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cifop.tn.entities.Student;
import com.cifop.tn.services.StudentServices;




public class Application {


	/**
	 * 
	 * By using below code we are connecting to the database and returning the
	 * connection object.
	 * 
	 * @return
	 * 

	 * 
	 * @param args the command line arguments
	 * 
	 */

	public static void main(String[] args)

	{



		StudentServices studentServices = new StudentServices() ;
		Date dateOfBirthStudent1 = new Date(1992,10,26) ;
		Student student1 = new Student(1, "Salim", "Hadhri", "rue1", dateOfBirthStudent1) ;
		
		
		Date dateOfBirthStudent2 = new Date(1995,10,26) ;
		Student student2 = new Student(1, "mohamed", "Adli", "rue2", dateOfBirthStudent2) ;
		
		Date dateOfBirthStudent3 = new Date(1998,10,26) ;
		Student student3 = new Student(1, "jamel", "Boudabouz", "rue3", dateOfBirthStudent3) ;
		
		Date dateOfBirthStudent4 = new Date(2001,10,26) ;
		Student student4 = new Student(1, "Gad", "Maleh", "rue4", dateOfBirthStudent4) ;
		
		List<Student> listOfStudents = new ArrayList<Student>() ;
		
		listOfStudents.add(student1);
		listOfStudents.add(student2);
		listOfStudents.add(student3);
		listOfStudents.add(student4);
		
		//ClassRoom classRoom = new ClassRoom(1, "DH", "oneClassRoom", listOfStudents) ;
		
		studentServices.addStudent(student1);
		studentServices.addStudent(student2);
		studentServices.addStudent(student3);
		studentServices.addStudent(student4);


	}


	

}
