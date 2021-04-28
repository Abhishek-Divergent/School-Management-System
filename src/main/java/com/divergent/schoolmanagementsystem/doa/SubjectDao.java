package com.divergent.schoolmanagementsystem.doa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergent.schoolmanagementsystem.entity.Subject;

@Repository
public class SubjectDao {
	@Autowired
	private Subject subject;
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("schooljpa");

	public void delete(int i) {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Subject s = entityManager.find(Subject.class, i);
		entityManager.remove(s);
		entityTransaction.commit();
		entityManager.close();
	}

	public void update(int i, String name) {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		subject = entityManager.find(Subject.class, i);
		subject.setName(name);
		entityTransaction.commit();
		entityManager.close();

	}

	public void create(int id, String name) throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		subject.setId(id);
		subject.setName(name);
		entityTransaction.begin();
		entityManager.persist(subject);
		entityTransaction.commit();
		entityManager.close();
	}

	public void read() throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT id,name FROM  Subject");
        System.out.println(query.getResultList()); 
		entityTransaction.commit();
		entityManager.close();
	}
}
