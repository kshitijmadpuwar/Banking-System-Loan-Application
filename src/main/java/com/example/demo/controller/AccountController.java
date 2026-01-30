package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountEntity;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	//=================== Create Banck Account ==================
	@PostMapping("/createAcc")
	public String createAccount(@RequestBody AccountEntity acc) {
		this.accountService.createBankAccount(acc);
		return "Account Created ...!";
	}
	
	
	//=================== Deposite Money =======================
	@PostMapping("/deposit")
	public String depositMoney(@RequestParam Long accNo , @RequestParam Double amount) {
		this.accountService.depositeMoney(accNo, amount);
		return " Money Deposite...!";
	}
	
	//=================== Tranfer money ========================
	@PostMapping("/moneyTransfer")
	public String moneyTranfer(@RequestParam Long accNo01 ,@RequestParam Long accNo02,@RequestParam Double amount) {
		this.accountService.moneyTranser(accNo01, accNo02, amount);
		
		return "Money Tranfered...!";
	}
	
	//=================== Withdreaw Money =======================
	@GetMapping("/withdrawMoney")
	public String WithdrawMoney(@RequestParam Long accNo ,@RequestParam Double amount) {
		this.accountService.withdrawMoney(accNo, amount);
		
		return "Money Withdrawed...!";
	}
	
	//=================== Check balance =========================
	@GetMapping("/checkBalance")
	public Double checkBalnce(@RequestParam Long accNo ) {
		return this.accountService.CheckBalance(accNo);
	}
	
	//================== Transaction Check =======================
	
}
