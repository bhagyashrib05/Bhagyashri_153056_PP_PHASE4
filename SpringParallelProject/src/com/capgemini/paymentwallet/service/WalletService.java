package com.capgemini.paymentwallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Transactions;
import com.capgemini.paymentwallet.exception.CustomerDetailsNotFoundException;
import com.capgemini.paymentwallet.exception.InsufficientBalanceException;
import com.capgemini.paymentwallet.exception.InvalidInputException;

public interface WalletService {

	public Customer createAccount(Customer customer) throws InvalidInputException;

	public Customer showBalance(String mobileNo) throws CustomerDetailsNotFoundException;

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InsufficientBalanceException, InvalidInputException;

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException;

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InsufficientBalanceException, InvalidInputException;

	public List<Transactions> showTransaction(String mobileNo) throws InvalidInputException;
	
	public List<Customer> getLowBalanceDetails() throws InvalidInputException;
	
	public List<Customer> getAllCustomersDetails() throws InvalidInputException ;


}
