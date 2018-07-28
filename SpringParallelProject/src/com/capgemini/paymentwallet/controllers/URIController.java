package com.capgemini.paymentwallet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Transactions;

@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getIndexPage(){
		return "indexPage";
	}


	@RequestMapping(value="/login")
	public String getLoginPage(){
		return "loginPage";
	}


	@RequestMapping(value="/register")
	public String getRegistrationPage(){
		return "registrationPage";
	}

	@RequestMapping(value="/deposit")
	public String getDepositPage(){
		return "depositPage";
	}

	@RequestMapping(value="/withdraw")
	public String getWithdrawPage(){
		return "withdrawPage";
	}

	@RequestMapping(value="/transferFund")
	public String getFundTransferPage(){
		return "fundTransferPage";
	}

	@RequestMapping(value="/transactions")
	public String getTransactionsPage(){
		return "transactionsPage";
	}
	
	@RequestMapping(value="/lowbalancecustomers")
	public String getlowBalCustomersPage(){
		return "lowBalCustPage";
	}
	
	@RequestMapping(value="/allcustomers")
	public String getAllCustomersPage(){
		return "allCustomersPage";
	}

	@RequestMapping(value="/logout")
	public String getLogoutPage(){
		return "logoutPage";
	}

	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}

	@ModelAttribute("transaction")
	public Transactions getTrans() {
		return new Transactions();
	}

	@ModelAttribute("transactions")
	public List<Transactions> getTransaction() {
		return new ArrayList<Transactions>();
	}



}
