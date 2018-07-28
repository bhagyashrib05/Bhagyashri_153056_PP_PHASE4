package com.capgemini.paymentwallet.beans;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


@Embeddable
public class Wallet {

	@NotNull
	@NotEmpty
	@Column(name="c_balance")
	private BigDecimal balance;

	public Wallet() {
		super();
	}

	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Wallet [balance=" + balance + "]";
	}
}
