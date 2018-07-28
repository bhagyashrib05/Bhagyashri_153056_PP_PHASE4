package com.capgemini.paymentwallet.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.exception.CustomerDetailsNotFoundException;
import com.capgemini.paymentwallet.exception.InvalidInputException;
import com.capgemini.paymentwallet.service.WalletService;

@SessionAttributes("mobileNo")
@Controller
public class CustomerActionController {

	@Autowired
	private WalletService wServices;

	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult result) {

		try {
			if(result.hasErrors())return new ModelAndView("registrationPage");
			customer= wServices.createAccount(customer);
		} catch (InvalidInputException e) {
			e.getMessage();
		}

		return new ModelAndView("registrationSuccessPage","customer", customer);
	}

	@RequestMapping("/loginCustomer")
	public ModelAndView loginCustomer(@RequestParam("mobileNo")String mobileNo,HttpServletRequest request) {

		Customer customer;
		try {
			customer = wServices.showBalance(mobileNo);
			request.getSession().setAttribute("mobileNo", mobileNo);
			return new ModelAndView("loginSuccessPage","customer", customer);
		} catch (CustomerDetailsNotFoundException e) {
			return new ModelAndView("loginPage","errorMessage",e.getMessage());
		}

		
	}
}
