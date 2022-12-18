package com.akhm.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.akhm.customer.service.CustomerService;
import com.akhm.customer.service.vo.CustomerVO;

public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customerregistration")
	public ResponseEntity<CustomerVO> register(@RequestBody CustomerVO customerVO) {

		try {
			CustomerVO customer = customerService.insertCoustomer(customerVO);
			return new ResponseEntity(customer, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/customerlogin")
	public ResponseEntity<CustomerVO> login(@RequestBody CustomerVO customerVO) {
		try {
			CustomerVO customer = customerService.getCustomer(customerVO.getEmailId(), customerVO.getPassword());
			return new ResponseEntity(customer, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}