
	package com.jspiders.onetomany.dao;

	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;

	import com.jspiders.onetomany.dto.CompanyDTO;
	import com.jspiders.onetomany.dto.EmployeeDTO;

	public class CompanyDAO3 {
		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager entityManager;
		private static EntityTransaction entityTransaction;
		public static void main(String[] args) {
			
			CompanyDTO company=new CompanyDTO();
			company.setName("tata");
			company.setLocation("pune");
			
			EmployeeDTO employee1=new EmployeeDTO();
			employee1.setName("ramesh");
			employee1.setEmail("ramesh@gmail.com");
			employee1.setMobile(9876543210l);
			
			EmployeeDTO employee2=new EmployeeDTO();
			employee2.setName("suresh");
			employee2.setEmail("suresh@gmail.com");
			employee2.setMobile(9876543211l);
			
			EmployeeDTO employee3=new EmployeeDTO();
			employee3.setName("mahesh");
			employee3.setEmail("mahesh@gmail.com");
			employee3.setMobile(9876543212l);
			
			EmployeeDTO employee4=new EmployeeDTO();
			employee4.setName("umesh");
			employee4.setEmail("umesh@gmail.com");
			employee4.setMobile(9876543213l);
			
			List<EmployeeDTO> employee=new ArrayList<EmployeeDTO>();
			employee.add(employee1);
			employee.add(employee2);
			employee.add(employee3);
			employee.add(employee4);
			company.setEmployee(employee);
			openConnection();
			entityTransaction.begin();
			
			entityManager.persist(company);
			
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


