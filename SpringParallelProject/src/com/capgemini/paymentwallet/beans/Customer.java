package com.capgemini.paymentwallet.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity

public class Customer {

	@Column(name="c_name")
	@NotEmpty
	@NotNull
	@Pattern(regexp="^([A-Z]{1}\\w+)$")
	private String name;
	@Id
	@Column(name="c_mobile_no")
	@NotNull
	@NotEmpty
	@Pattern(regexp="^[7-9]{1}[0-9]{9}$")
	private String mobileNo;


	@Embedded
	private Wallet wallet;


	public Customer() {
		super();
	}

	public Customer(String mobileNo) {
		super();
		this.mobileNo = mobileNo;
	}

	public Customer(String name, String mobileNo, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}




}