package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.CompanyDTO;
import com.jspiders.manytoone.dto.EmployeeDTO;

public class EmployeeDAO2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		EmployeeDTO employees=new EmployeeDTO();
		employees.setName("suresh");
		employees.setEmail("suresh@gmail.com");
		employees.setMobile(9876543211l);
		
		CompanyDTO company=entityManager.find(CompanyDTO.class, 1);
		
		employees.setCompany(company);
		entityManager.persist(employees);
		
		entityTransaction.commit();
		closeConnection();
	}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
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
