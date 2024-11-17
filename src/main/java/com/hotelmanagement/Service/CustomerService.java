package com.hotelmanagement.Service;

import java.util.List;

import com.binding.CustomerRequest;
import com.binding.CustomerResponse;

public interface CustomerService {

	public CustomerResponse fetchCustomerById(Integer custId);//completed
	
	public List<CustomerResponse> fetchCustomerByName(String custName);//completed
	
	public CustomerResponse fetchCustomerByAadharNo(String custAadharNo);//completed
	
	public CustomerResponse fetchCustomerByMobileNo(String custMobileNo);//completed
	
	public List<CustomerResponse> fetchCustomerByGender(String custGender);//completed
	
	public boolean saveCustomer (CustomerRequest cr);//completed
	
	public CustomerResponse updateCustomer(CustomerRequest cre,Integer custId);
	
	public boolean deleteCustomer(Integer custId);//completed
	
	
	
	
}
