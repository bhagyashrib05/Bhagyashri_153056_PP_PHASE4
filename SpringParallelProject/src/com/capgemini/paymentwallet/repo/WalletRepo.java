package com.capgemini.paymentwallet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.paymentwallet.beans.Customer;

public interface WalletRepo extends JpaRepository<Customer, String>{

	@Query(value= "select cust from Customer cust where cust.wallet<1000"  )
	public List<Customer> getDetails();
	
	@Query(value= "select cust from Customer cust" )
	
	public List<Customer> getAllDetails();

}
