package com.divergent.schoolmanagementsystem.doa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergent.schoolmanagementsystem.entity.Teacher;

@Repository
public class TeacherDao {
	@Autowired
	private Teacher teacher;
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("schooljpa");

	public void delete(int i) {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		teacher = entityManager.find(Teacher.class, i);
		entityManager.remove(teacher);
		entityTransaction.commit();
		entityManager.close();
	}

	public void update(int id, String firstname, String lastname, int subjectid) {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		teacher = entityManager.find(Teacher.class, id);
		teacher.setId(id);
		teacher.setFirstname(firstname);
		teacher.setLastname(lastname);
		teacher.setSubjectid(subjectid);
		entityTransaction.commit();
		entityManager.close();

	}

	public void create(int id, String firstname, String lastname, int subjectid) throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		teacher.setId(id);
		teacher.setFirstname(firstname);
		teacher.setLastname(lastname);
		teacher.setSubjectid(subjectid);

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		entityManager.close();
	}

	public Query read() {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT id, firstname, lastname, subjectid FROM  Teacher");
		 System.out.println(query.getResultList()); 
		entityTransaction.commit();
		entityManager.close();
		return query;
	}
}
