package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountEntity;
import com.example.demo.repository.AccountRepository;





@Service
public class AccountService { 

	@Autowired 
	AccountRepository accountRepository;
	
	@Autowired 
	TransactionService transactionService;
	
	//=================== Create Banck Account ==================
	public void createBankAccount(AccountEntity acc) {
		String accType=acc.getAccType();
		if(accType.equalsIgnoreCase("saving") || accType.equalsIgnoreCase("current")) {
			this.accountRepository.save(acc);
		}else {
			throw new IllegalArgumentException(" Wrong account Type Entered...!");
		}
		
		
	}
	
	//=================== Deposite Money ========================
	
	public void depositeMoney(Long AccountNumber , Double amount) {
		
		if( amount == null ||amount <=0) {
			throw new IllegalArgumentException("Amount Must be grater then Zero..!!");
		}
		
		AccountEntity account = accountRepository.findByaccNumber(AccountNumber).orElseThrow(() -> new RuntimeException("Accout Not Found Of : "+AccountNumber));

		Double newBalance =account.getBalance() + amount;
		account.setBalance(newBalance);
		
		
		this.accountRepository.save(account);
		transactionService.depositeMoney(AccountNumber, amount);
		
	}
	
	//==================== Tranfer Money =====================
	public void  moneyTranser(Long accNo01, Long accNo02 , Double amount) {
		
		AccountEntity account1 = accountRepository.findByaccNumber(accNo01).orElseThrow(() -> new RuntimeException("Account Not Found OF : "+accNo01));
		AccountEntity account2 = accountRepository.findByaccNumber(accNo02).orElseThrow(() -> new RuntimeException("Account Not Found OF : "+accNo02));
       
		if(  amount == null||amount <=0 ) {
			throw new IllegalArgumentException(" Amount Must be grater then Zero...!!!");
		}
		
		if(account1.getBalance() < amount) {
			throw new RuntimeException(" Insufficient Balance in Account "+accNo01);
		}
		Double remainingBal = account1.getBalance() - amount;
		
		
		if( account1.getAccType().equalsIgnoreCase("saving") && remainingBal < 1000) {
			throw new IllegalArgumentException(" Insufficient Amount , Minimun balance must be Grater then 1000");
			
		}else if(account1.getAccType().equalsIgnoreCase("current") && remainingBal < 3000) {
			throw new IllegalArgumentException(" Insufficient Amount , Minimun balance must be Grater then 3000");
		}
		 
		//Deduct from Sender
	   account1.setBalance(account1.getBalance() - amount);
	   
	   //add to revicer
	   account2.setBalance(account2.getBalance()+amount);
	    
	  
	    
	    this.accountRepository.save(account1);
	    this.accountRepository.save(account2);
	    transactionService.tranferMoney(accNo01, accNo02, amount);
	}
	
	
	//==================== Check Balance =======================
	public Double CheckBalance(Long accNo) {
		
		AccountEntity account = accountRepository.findByaccNumber(accNo).orElseThrow(() -> new RuntimeException("Account Not Found "+accNo));
		Double getbalance = account.getBalance();
		return getbalance;
		
	}
	
	//================== Withdraw Money ========================
	public Double withdrawMoney(Long accNo , Double amount) {
		
		if(  amount == null|| amount <=0 ) {
			throw new IllegalArgumentException(" Amount Must be grater then Zero...!!!");
		}
		AccountEntity account = accountRepository.findByaccNumber(accNo).orElseThrow(() -> new RuntimeException("Account Not Found "+accNo));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Amount in Account ");
		}
		
		Double remainingBal = account.getBalance() - amount;
		
		if( account.getAccType().equalsIgnoreCase("saving") && remainingBal < 1000) {
			throw new IllegalArgumentException(" Insufficient Amount , Minimun balance must be Grater then 1000");
			
		}else if(account.getAccType().equalsIgnoreCase("current") && remainingBal < 3000) {
			throw new IllegalArgumentException(" Insufficient Amount , Minimun balance must be Grater then 3000");
		}
		
		account.setBalance(remainingBal);
		
	
		
		this.accountRepository.save(account);
		transactionService.withdrawMoney(accNo, amount);
		return account.getBalance();
		
	}
	
}
