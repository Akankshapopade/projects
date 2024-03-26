package com.jspiders.onetoone1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="adhar")
public class AdharDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column(nullable = false,unique = true)
private long adharNumber;
}
