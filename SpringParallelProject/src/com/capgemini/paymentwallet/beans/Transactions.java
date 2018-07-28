package com.capgemini.paymentwallet.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transactions {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transId;

	@Column(name="c_mobile_no")
	private String mobileNo;

	@Column(name="trans_date")
	private Date transDate;

	@Column(name="trans_message")
	String transMessage;

	@Column(name="trans_amount")
	BigDecimal transAmount;

	public Transactions() {
		super();
	}


	public Transactions(String mobileNo, Date transDate, String transMessage, BigDecimal transAmount) {
		super();
		this.mobileNo = mobileNo;
		this.transDate = transDate;
		this.transMessage = transMessage;
		this.transAmount = transAmount;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTransMessage() {
		return transMessage;
	}

	public void setTransMessage(String transMessage) {
		this.transMessage = transMessage;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}


	public BigDecimal getTransAmount() {
		return transAmount;
	}


	public void setTransAmount(BigDecimal transAmount) {
		this.transAmount = transAmount;
	}




}
