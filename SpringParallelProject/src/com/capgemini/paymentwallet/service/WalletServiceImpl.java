package com.capgemini.paymentwallet.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Transactions;
import com.capgemini.paymentwallet.exception.CustomerDetailsNotFoundException;
import com.capgemini.paymentwallet.exception.InsufficientBalanceException;
import com.capgemini.paymentwallet.exception.InvalidInputException;
import com.capgemini.paymentwallet.repo.TransactionsRepo;
import com.capgemini.paymentwallet.repo.WalletRepo;

@Component(value = "walletServices")
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo repo;

	@Autowired
	private TransactionsRepo tRepo;

	@Override
	public Customer createAccount(Customer customer) throws InvalidInputException {

		return repo.save(customer);

	}

	@Override
	public Customer showBalance(String mobileNo) throws CustomerDetailsNotFoundException {
		Customer cust = repo.findOne(mobileNo);
		if (cust == null)
			throw new CustomerDetailsNotFoundException("Customer not found");

		return cust;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount)
			throws InsufficientBalanceException, InvalidInputException {

		Customer source = repo.findOne(sourceMobileNo);
		Customer target = repo.findOne(targetMobileNo);

		source.getWallet().setBalance(source.getWallet().getBalance().subtract(amount));

		Transactions Stransactions = new Transactions(targetMobileNo, new Date(), "FUND TRANSFER", amount);

		tRepo.save(Stransactions);

		target.getWallet().setBalance(target.getWallet().getBalance().add(amount));

		Transactions Ttransactions = new Transactions(sourceMobileNo, new Date(), "FUND TRANSFER", amount);

		tRepo.save(Ttransactions);

		repo.save(target);

		return repo.save(source);
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException {

		Customer customer = repo.findOne(mobileNo);

		customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));

		Transactions transactions = new Transactions(mobileNo, new Date(), "DEPOSIT", amount);

		tRepo.save(transactions);

		return repo.save(customer);
	}

	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount)
			throws InsufficientBalanceException, InvalidInputException {

		Customer customer = repo.findOne(mobileNo);

		customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(amount));

		Transactions transactions = new Transactions(mobileNo, new Date(), "WITHDRAW", amount);

		tRepo.save(transactions);

		return repo.save(customer);

	}

	public List<Transactions> showTransaction(String mobileNo) throws InvalidInputException {

		List<Transactions> transList = tRepo.getAllTransactions(mobileNo);

		return transList;
	}

	public List<Customer> getLowBalanceDetails() throws InvalidInputException {

		List<Customer> custList = repo.getDetails();

		return custList;
	}

	public List<Customer> getAllCustomersDetails() throws InvalidInputException {

		List<Customer> custList = repo.getAllDetails();

		return custList;
	}
}
