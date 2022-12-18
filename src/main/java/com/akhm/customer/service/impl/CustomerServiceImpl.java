package com.akhm.customer.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.customer.exception.CustomerDataException;
import com.akhm.customer.repository.CustomerRepository;
import com.akhm.customer.repository.entity.CustomerTl;
import com.akhm.customer.service.CustomerService;
import com.akhm.customer.service.vo.CustomerVO;
import com.akhm.customer.util.DateUtil;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DateUtil dateUtil;

	@Override
	public CustomerVO insertCoustomer(CustomerVO customerVO) {
		try {
			if (customerVO != null) {
				CustomerTl customerTl = new CustomerTl();
				customerTl.setCustomerName(customerVO.getCustomerName());
				customerTl.setEmailId(customerVO.getEmailId());
				customerTl.setMobileNumber(customerVO.getMobileNumber());
				customerTl.setCustomerStatus(customerVO.getCustomerStatus());
				customerTl.setIsEmailVerified(customerVO.getIsEmailVerified());
				customerTl.setIsMobileNumberVerified(customerVO.getIsMobileNumberVerified());
				customerTl.setDateOfBirth(dateUtil.currentDate());
				customerTl.setCreatedOn(dateUtil.currentDate());
				CustomerTl customer = customerRepository.save(customerTl);
				CustomerVO cust = new CustomerVO();
				cust.setCustomerId(customer.getCustomerId());
				cust.setCustomerName(customer.getCustomerName());
				cust.setEmailId(customer.getEmailId());
				cust.setMobileNumber(customer.getMobileNumber());
				cust.setCustomerStatus(customer.getCustomerStatus());
				cust.setIsEmailVerified(customer.getIsEmailVerified());
				cust.setIsMobileNumberVerified(customer.getIsMobileNumberVerified());
				cust.setDateOfBirth(dateUtil.convertDateToString(customer.getDateOfBirth()));
				cust.setCreatedOn(dateUtil.convertDateToString(customer.getCreatedOn()));
				return cust;
			} 
			else 
			{
				return null;
			}
		} 
		catch (Exception e)
		{
			throw new CustomerDataException(e.getMessage());
		}
	}

	@Override
	public CustomerVO getCustomer(String emailId, String password) {
		try {
			CustomerTl customer = customerRepository.findByEmailIdAndPassword(emailId, password);
			if (customer != null) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setCustomerId(customer.getCustomerId());
				customerVO.setCustomerName(customer.getCustomerName());
				customerVO.setEmailId(customer.getEmailId());
				customerVO.setMobileNumber(customer.getMobileNumber());
				customerVO.setCustomerStatus(customer.getCustomerStatus());
				customerVO.setIsEmailVerified(customer.getIsEmailVerified());
				customerVO.setIsMobileNumberVerified(customer.getIsMobileNumberVerified());
				customerVO.setDateOfBirth(dateUtil.convertDateToString(customer.getDateOfBirth()));
				customerVO.setCreatedOn(dateUtil.convertDateToString(customer.getCreatedOn()));
				
				return customerVO;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new CustomerDataException(e.getMessage());
		}
	}

}