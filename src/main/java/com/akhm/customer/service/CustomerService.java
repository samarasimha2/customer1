package com.akhm.customer.service;

import com.akhm.customer.service.vo.CustomerVO;

public interface CustomerService {
	public CustomerVO insertCoustomer(CustomerVO customerVO);
	public CustomerVO getCustomer(String emailId,String password);

}