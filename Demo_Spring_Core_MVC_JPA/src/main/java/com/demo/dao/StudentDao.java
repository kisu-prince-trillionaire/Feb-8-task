package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.bean.Student;
import com.demo.config.JPAUtil;

@Repository
public class StudentDao {

	public void insertStudent(Student student) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void updateStudent(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Student student = entityManager.find(Student.class, id);
		System.out.println("student id :: " + student.getId());
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student lastname :: " + student.getLastName());
		System.out.println("student email :: " + student.getEmail());

		student.setFirstName("Ram");
		student.setLastName("jadhav");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Student student = entityManager.find(Student.class, id);
		System.out.println("student id :: " + student.getId());
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student lastname :: " + student.getLastName());
		System.out.println("student email :: " + student.getEmail());
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void getStudent(int id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Student student = entityManager.find(Student.class, id);
		System.out.println("student id :: " + student.getId());
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student lastname :: " + student.getLastName());
		System.out.println("student email :: " + student.getEmail());
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void getStudents() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("Select s from Student s");
		@SuppressWarnings("unchecked")
		List<Student> list = query.getResultList();

		for (Student student : list) {
			System.out.println("student id :: " + student.getId());
			System.out.println("student firstname :: " + student.getFirstName());
			System.out.println("student lastname :: " + student.getLastName());
			System.out.println("student email :: " + student.getEmail());
			System.out.println("-----------------------------------------------");
		}
		entityManager.close();
	}
}
