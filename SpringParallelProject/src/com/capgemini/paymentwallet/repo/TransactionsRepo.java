package com.capgemini.paymentwallet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.paymentwallet.beans.Transactions;

public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {

	@Query(value="Select t from Transactions t where t.mobileNo =:mobileNo")
	public List<Transactions> getAllTransactions(@Param("mobileNo")String mobileNo);

}
