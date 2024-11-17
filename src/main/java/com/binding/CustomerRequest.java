package com.binding;

import lombok.Data;

@Data
public class CustomerRequest {

    private Integer custId;
	
	private String custName;
	
	private String custAadharNo;
	
	private String custMobileNo;
	
	private String custGender;
	
	private Integer custAge;
	
	private Integer noOfOccupants;
	
}
