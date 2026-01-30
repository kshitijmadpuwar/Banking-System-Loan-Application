package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	//========================= save Transaction tranfermoney =====================
	public void tranferMoney(Long fromAcc , Long toAcc , Double amount) {
		
		TransactionEntity transaction = new TransactionEntity();
		transaction.setFromAccount(fromAcc);
		transaction.setToAccount(toAcc);
		transaction.setAmount(amount);
		transaction.setType("tranfer");
		transaction.setTransactionDate(LocalDateTime.now());

		
		transactionRepository.save(transaction);
	}
	
	//======================= Deposite transaction =======================
	public void depositeMoney(Long accNo , Double amount) {
		
		TransactionEntity transaction = new TransactionEntity();
		transaction.setFromAccount(accNo);
		transaction.setToAccount(null);
		transaction.setAmount(amount);
		transaction.setType("deposit");
		transaction.setTransactionDate(LocalDateTime.now());

		
		transactionRepository.save(transaction);
	}
	
	//====================== withdraw =========================
	public void withdrawMoney(Long accNo , Double amount) {

		TransactionEntity transaction = new TransactionEntity();
		transaction.setFromAccount(accNo);
		transaction.setToAccount(null);
		transaction.setAmount(amount);
		transaction.setType("withdraw");
		transaction.setTransactionDate(LocalDateTime.now());
		
		transactionRepository.save(transaction);
	}
	
	//======================= MiniStatement =========================
	public List<TransactionEntity> getMiniStatement(Long accNo) {
	    return transactionRepository.findByFromAccountOrToAccount(accNo, accNo);
	}

}
