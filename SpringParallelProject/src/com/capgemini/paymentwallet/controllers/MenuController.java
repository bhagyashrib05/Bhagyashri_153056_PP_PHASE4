package com.capgemini.paymentwallet.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Transactions;
import com.capgemini.paymentwallet.exception.InsufficientBalanceException;
import com.capgemini.paymentwallet.exception.InvalidInputException;
import com.capgemini.paymentwallet.service.WalletService;



@Controller
@Scope("session")
public class MenuController {

	@Autowired
	private WalletService wServices;

	@RequestMapping(value="/depositAmount")
	public ModelAndView depositAmount(@RequestParam("amount")BigDecimal amount, HttpServletRequest request){

		String mobileNo = (String)request.getSession().getAttribute("mobileNo");

		Customer customer;
		try {
			customer = wServices.depositAmount(mobileNo, amount);
		} catch (InvalidInputException e) {
			return new ModelAndView("errorPage");
		}

		return new ModelAndView("transactionSuccessPage","customer", customer);
	}


	@RequestMapping(value="/withdrawAmount")
	public ModelAndView withdrawAmount(@RequestParam("amount")BigDecimal amount, HttpServletRequest request){

		String mobileNo = (String)request.getSession().getAttribute("mobileNo");

		Customer customer;
		try {
			try {
				customer = wServices.withdrawAmount(mobileNo, amount);
			} catch (InsufficientBalanceException e) {
				return new ModelAndView("errorPage");
			}
		} catch (InvalidInputException e) {
			return new ModelAndView("errorPage");
		}

		return new ModelAndView("transactionSuccessPage","customer", customer);
	}

	@RequestMapping(value="/fundTransfer")
	public ModelAndView fundTransfer(@RequestParam("targetMobileNo")String targetMobileNo, @RequestParam("amount")BigDecimal amount, HttpServletRequest request){

		String sourceMobileNo = (String)request.getSession().getAttribute("mobileNo");

		Customer customer;
		try {
			try {
				customer = wServices.fundTransfer(sourceMobileNo, targetMobileNo, amount);
			} catch (InsufficientBalanceException e) {
				return new ModelAndView("errorPage");
			}
		} catch (InvalidInputException e) {
			return new ModelAndView("errorPage");
		}

		return new ModelAndView("transactionSuccessPage","customer", customer);
	}

	@RequestMapping(value="/showTransactions")
	public ModelAndView showTransactions(HttpServletRequest request){

		String mobileNo = (String)request.getSession().getAttribute("mobileNo");

		List<Transactions> messages = new ArrayList<>();
		try {
			messages = wServices.showTransaction(mobileNo);
		} catch (InvalidInputException e) {
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("showTransactionsSuccessPage","transactions", messages);
	}
	
	@RequestMapping(value="/showlowBalCust")
	public ModelAndView showLowBalCustomers(){

		List<Customer> customer = new ArrayList<>();
		try {
			customer = wServices.getLowBalanceDetails();
		} catch (InvalidInputException e) {
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("lowBalCustSuccessPage","customer", customer);
	}
	
	@RequestMapping(value="/showAllCustomers")
	public ModelAndView showAllCustomers(){
		
	List<Customer> customer = new ArrayList<>();
	try {
		customer = wServices.getAllCustomersDetails();
	} catch (InvalidInputException e) {
		return new ModelAndView("errorPage");
	}
	return new ModelAndView("AllCustomersSuccessPage","customer", customer);
	}


}
