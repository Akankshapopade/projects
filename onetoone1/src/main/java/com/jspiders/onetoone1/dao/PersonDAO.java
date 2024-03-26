package com.jspiders.onetoone1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone1.dto.AdharDTO;
import com.jspiders.onetoone1.dto.PersonDTO;

public class PersonDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		PersonDTO person=new PersonDTO();
		person.setName("suresh");
		person.setEmail("suresh@gmail.com");
		person.setMobile(9876543211l);
		person.setAge(24);
		AdharDTO adhar=new AdharDTO();
		adhar.setAdharNumber(12345678911l);
		person.setAdharDTO(adhar);
		openConnection();
		entityTransaction.begin();
		entityManager.persist(adhar);
		entityManager.persist(person);
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		}
		private static void closeConnection() {
		  if (entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		  if (entityManager!=null) {
			entityManager.close();
		}
		  if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
		}
}
