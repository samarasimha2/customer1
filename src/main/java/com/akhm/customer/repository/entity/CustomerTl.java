package com.akhm.customer.repository.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="CUSTOMER_TL")
@Data 
public class CustomerTl {
	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue
	private Integer customerId;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="EMAIL_ID")
	private String emailId;
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name="CUSTOMER_STATUS")
	private String customerStatus;
	@Column(name="IS_EMAIL_VERIFIED")
	private String isEmailVerified;
	@Column(name="IS_MOBILE_NUMBER_VERIFIED")
	private String isMobileNumberVerified;
	@Column(name="CREATED_ON")
	private Date createdOn;
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	@Column(name="PASSWORD")
	private String password;
	

}