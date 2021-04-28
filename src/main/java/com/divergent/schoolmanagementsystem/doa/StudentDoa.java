package com.divergent.schoolmanagementsystem.doa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergent.schoolmanagementsystem.entity.Student;

@Repository
public class StudentDoa {
	@Autowired
	private Student student;
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("schooljpa");

	public void delete(int id) {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		student = entityManager.find(Student.class, id);
		entityManager.remove(student);
		entityTransaction.commit();
		entityManager.close();

	}

	public void update(int id, String firstname, String lastname, int classid) {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		student = entityManager.find(Student.class, id);
		student.setId(id);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setClassid(classid);
		entityTransaction.commit();
		entityManager.close();

	}

	public void create(int id, String firstname, String lastname, int classid) {

		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		student.setId(id);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setClassid(classid);
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		entityManager.close();
	}

	public void read() {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT id, firstname, lastname, classid FROM  Student");
		System.out.println(query.getResultList());

		entityManager.close();
		entityTransaction.commit();

	}

}
