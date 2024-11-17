package com.hotelmanagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer,Integer>{

	public Customer findBycustMobileNo(String custMobileNo);
	
	public Customer findBycustAadharNo(String custAadharNo);
	
	public List<Customer> findBycustName(String custName);

	public List<Customer> findBycustGender(String custGender);
	
	
}
