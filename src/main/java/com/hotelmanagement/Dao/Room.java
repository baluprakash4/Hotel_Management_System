package com.hotelmanagement.Dao;

import java.time.LocalDateTime; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Table_Details")
public class Room {
	
	@Id
	private Integer roomNo;
	
	private String roomType;
	
	private Integer floorNo;
	
	
	
	
	private String createdBy;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDateTime creationTime;
	
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(updatable=false)
	private LocalDateTime updationTime;
	
}
