package com.hotelmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.binding.CustomerRequest;
import com.binding.CustomerResponse;
import com.hotelmanagement.Service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

//    public CustomerResponse fetchCustomerById(Integer custId);
	
	@GetMapping("/customer/custId/{custId}")
	public ResponseEntity<CustomerResponse> fetchCustomerById(@PathVariable Integer custId) {
		
		CustomerResponse fetchCustomerById = customerService.fetchCustomerById(custId);
		
		
			return new ResponseEntity<CustomerResponse>(fetchCustomerById,HttpStatus.OK);
		
		
	}
//	public List<CustomerResponse> fetchCustomerByName(String custName);
	@GetMapping("/customer/custName/{custName}")
	public ResponseEntity<List<CustomerResponse>> fetchCustomerByName(@PathVariable String custName){
		
		List<CustomerResponse> fetchCustomerByName = customerService.fetchCustomerByName(custName);
		
		return new ResponseEntity<>(fetchCustomerByName,HttpStatus.OK);
	}
	
//	public CustomerResponse fetchCustomerByAadharNo(String custAadharNo);
	@GetMapping("/customer/custAadharNo/{custAadharNo}")
	public ResponseEntity<CustomerResponse> fetchCustomerByAadharNo(@PathVariable String custAadharNo){
		CustomerResponse fetchCustomerByAadharNo = customerService.fetchCustomerByAadharNo(custAadharNo);
		return new ResponseEntity<CustomerResponse>(fetchCustomerByAadharNo,HttpStatus.OK);
	}

//	public CustomerResponse fetchCustomerByMobileNo(String custMobileNo);
	@GetMapping("/customer/custMobileNo/{custMobileNo}")
	public ResponseEntity<CustomerResponse> fetchCustomerByMobileNo(@PathVariable String custMobileNo){
		CustomerResponse fetchCustomerByMobileNo = customerService.fetchCustomerByMobileNo(custMobileNo);
		
		return new ResponseEntity<CustomerResponse>(fetchCustomerByMobileNo,HttpStatus.OK);
	}
	
	
//	public List<CustomerResponse> fetchCustomerByGender(String custGender);
	@GetMapping("/customer/custGender/{custGender}")
	public ResponseEntity<List<CustomerResponse>> fetchCustomerByGener(@PathVariable String custGender){
		List<CustomerResponse> fetchCustomerByGender = customerService.fetchCustomerByGender(custGender);
		
		return  new ResponseEntity<List<CustomerResponse>>(fetchCustomerByGender,HttpStatus.OK);
		
	}

//	public boolean saveCustomer (CustomerRequest cr);
	@PostMapping("/customer")
	public ResponseEntity<String> saveCustomer(@RequestBody CustomerRequest cr ){
		
		boolean saveCustomer = customerService.saveCustomer(cr);
		if(saveCustomer==true) {
			
			return new ResponseEntity("Data Inseted Sucessfully",HttpStatus.OK);
			
		}
		else 
			return new ResponseEntity("check your data ",HttpStatus.BAD_REQUEST);
		
	}

//	public CustomerResponse updateCustomer(CustomerRequest cre);
	@PutMapping("/customer/custId/{custId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest cre, @PathVariable Integer custId){
		CustomerResponse updateCustomer = customerService.updateCustomer(cre,custId);
		if(updateCustomer !=null) {
		 return new ResponseEntity<CustomerResponse>(updateCustomer,HttpStatus.OK);
		}
		else return new ResponseEntity<CustomerResponse>(HttpStatus.NOT_FOUND);
			
	}
	

//	public boolean deleteCustomer(Integer custId);
	@DeleteMapping("/customer/custId/{custId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer custId){
		boolean deleteCustomer = customerService.deleteCustomer(custId);
		if(deleteCustomer==true) {
			return new ResponseEntity<String>("Data deleted sucessfully",HttpStatus.OK);
		}
		else if(custId<=0) {
			return new ResponseEntity<String>("Bad Input check your data",HttpStatus.BAD_REQUEST);
		}
		else 
			return new ResponseEntity<String>("Internal Server Error ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
