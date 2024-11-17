package com.hotelmanagement.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binding.CustomerRequest;
import com.binding.CustomerResponse;
import com.hotelmanagement.Dao.Customer;
import com.hotelmanagement.Dao.CustomerRepo;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Override
	public CustomerResponse fetchCustomerById(Integer custId) {
		
		Optional<Customer> byId = customerRepo.findById(custId);
		
		CustomerResponse cr=new CustomerResponse();
		
		if(byId.isPresent()) {
			Customer customer = byId.get();
			BeanUtils.copyProperties(customer, cr);
			return cr;
		}
		
		return null;
	}

	@Override
	public List<CustomerResponse> fetchCustomerByName(String custName) {
		
		List<Customer> bycustName = customerRepo.findBycustName(custName);
		
		List<CustomerResponse> customerResponses=new ArrayList<>();
		
		if(bycustName!=null && !bycustName.isEmpty()) {
			
			for(Customer customer:bycustName) {
			CustomerResponse cr=new CustomerResponse();
			BeanUtils.copyProperties(customer, cr);
			customerResponses.add(cr);
			
			}
			return customerResponses;
		}
		return Collections.emptyList();
	}

	@Override
	public CustomerResponse fetchCustomerByAadharNo(String custAadharNo) {
		
		Customer bycustAadharNo = customerRepo.findBycustAadharNo(custAadharNo);
		CustomerResponse cr=new CustomerResponse();
		if(bycustAadharNo!=null) {
			BeanUtils.copyProperties(bycustAadharNo, cr);
			return cr;
		}
		return null;
	}

	@Override
	public CustomerResponse fetchCustomerByMobileNo(String custMobileNo) {
	  
		Customer bycustMobileNo = customerRepo.findBycustMobileNo(custMobileNo);
		
		if(bycustMobileNo!=null) {
			
			CustomerResponse cr=new CustomerResponse();
			BeanUtils.copyProperties(bycustMobileNo, cr);
			return cr;
		}
		
		return null;
	}

	@Override
	public List<CustomerResponse> fetchCustomerByGender(String custGender) {
		
		List<Customer> bycustGender = customerRepo.findBycustGender(custGender);
	    System.out.println("Fetching customers for gender: " + custGender);

		List<CustomerResponse> custResponse=new ArrayList<>();
		
		if(custResponse!=null && !custGender.isEmpty()) {
			
			for(Customer customer:bycustGender)
			{
				CustomerResponse cr=new CustomerResponse();
				BeanUtils.copyProperties(customer, cr);
				custResponse.add(cr);
			}
			
			
		}
		return custResponse;
	}

	@Override
	public boolean saveCustomer(CustomerRequest cr) {
		
		if(cr!=null) {
		Customer c=new Customer();
		BeanUtils.copyProperties(cr, c);

		Customer save = customerRepo.save(c);
		return true;
		}
		
		return false;
	}

	
	@Override
	public CustomerResponse updateCustomer(CustomerRequest cre,Integer custId) {
		
		Optional<Customer> byId = customerRepo.findById(custId);
		if(byId.isPresent()) {
			Customer customer = byId.get();
			
			if(cre.getCustAadharNo()!=null) {
				customer.setCustAadharNo(cre.getCustAadharNo());
			}
			if(cre.getCustAge()!=null) {
				customer.setCustAge(cre.getCustAge());
			}
			if(cre.getCustGender()!=null) {
				customer.setCustGender(cre.getCustGender());
			}
			if(cre.getCustId()!=null) {
				customer.setCustId(cre.getCustId());
			}
			if(cre.getCustMobileNo()!=null) {
				customer.setCustMobileNo(cre.getCustMobileNo());
			}
			if(cre.getCustName()!=null) {
				customer.setCustName(cre.getCustName());
			}
			if(cre.getNoOfOccupants()!=null) {
				customer.setNoOfOccupants(cre.getNoOfOccupants());
			}
			customerRepo.save(customer);
			
			CustomerResponse cr=new CustomerResponse();
			
			BeanUtils.copyProperties(customer, cr,"custId");
			return cr;
		}
		return null;
	}
	

	@Override
	public boolean deleteCustomer(Integer custId) {
		
		Optional<Customer> byId = customerRepo.findById(custId);
		if(byId.isPresent()) {
			customerRepo.deleteById(custId);
			System.out.println("Customer Id "+custId+" is deleted");
			return true;
		}
		
		return false;
	}
	
	

}
