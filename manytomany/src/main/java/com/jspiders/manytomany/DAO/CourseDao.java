package com.jspiders.manytomany.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.DTO.Course;
import com.jspiders.manytomany.DTO.Student;

public class CourseDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Student student=entityManager.find(Student.class, 2);
		List<Course> courses=student.getCourses();
		Course dCourse=null;
		for (Course course : courses) {
			if (course.getName().equals("J2EE")) {
				dCourse=course;
			}
		}
		courses.remove(dCourse);
		student.setCourses(courses);
		entityManager.persist(student);
		
		Course course=entityManager.find(Course.class, 1);
		entityManager.remove(course);
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("student");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();	
	}
	private static void closeConnection() {
		if (entityManagerFactory!= null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction!= null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
