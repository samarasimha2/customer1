package com.akhm.customer.service.vo;

import java.sql.Date;

import com.akhm.customer.repository.entity.CustomerTl;

import lombok.Data;

@Data
public class CustomerVO {
	private Integer customerId;
	private String customerName;
	private String emailId;
	private String mobileNumber;
	private String customerStatus;
	private String isEmailVerified;
	private String isMobileNumberVerified;
	private String createdOn;
	private String dateOfBirth;
	private String password;

}