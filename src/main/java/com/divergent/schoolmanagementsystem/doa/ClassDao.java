package com.divergent.schoolmanagementsystem.doa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergent.schoolmanagementsystem.entity.ClassEntity;

@Repository
public class ClassDao {
	@Autowired
    private ClassEntity classobj;

	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("schooljpa");

	public void delete(int i)throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		classobj = entityManager.find(ClassEntity.class, i);
		entityManager.remove(classobj);
		entityTransaction.commit();
		entityManager.close();
	}

	public void update(int id, String name, String section, int teacherid)throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		classobj = entityManager.find(ClassEntity.class, id);
		classobj.setId(id);
		classobj.setName(name);
		classobj.setSection(section);
		classobj.setTeacherid(teacherid);
		entityTransaction.commit();
		entityManager.close();

	}

	public void create(int id, String name, String section, int teacherid) throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		classobj.setId(id);
		classobj.setName(name);
		classobj.setSection(section);
		classobj.setTeacherid(teacherid);
		entityTransaction.begin();
		entityManager.persist(classobj);
		entityTransaction.commit();
		entityManager.close();
	}

	public void read()throws Exception {
		EntityManager entityManager = managerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT id, name, section, teacherid FROM  ClassEntity");
	    System.out.println(query.getResultList()); 
		entityTransaction.commit();
		entityManager.close();

	}
}
