package com.jspiders.onetomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.EmployeeDTO;

public class CompanyDAO5 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	 public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();			
		EmployeeDTO employee=entityManager.find(EmployeeDTO.class, 2);
		employee.setMobile(9080504030l);
		entityManager.persist(employee);
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
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
