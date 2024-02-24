package com.jspiders.hibernatejpa.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data //it is used to import getters and setters
@Entity //it is used to mark the class as entity so hibernatejpa can understand it
public class StudentDTO {
	@Id //it is used to make an property as primary key.
 private int id;
 private String name;
 private String email;
 private long mobile;
 private int age;
 
}
