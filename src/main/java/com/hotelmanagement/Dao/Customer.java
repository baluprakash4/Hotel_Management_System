package com.hotelmanagement.Dao;

import java.time.LocalDateTime; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Customer_Details")
public class Customer {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY) 
	private Integer custId;
	
	private String custName;
	
	@Column(name = "cust_aadharno")
	private String custAadharNo;
	
	@Column(name = "cust_mobileno")
	private String custMobileNo;
	
	@Column(name = "cust_gender")
	private String custGender;
	
	private Integer custAge;
	
	private Integer noOfOccupants;
	
	
	private String createdBy;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDateTime createdTime;
	
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(updatable=false)
	private LocalDateTime updatedTime;
	
	
}
