package com.akhm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.customer.repository.entity.CustomerTl;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerTl, Integer> {
	public CustomerTl findByEmailIdAndPassword(String emailId, String password);
}