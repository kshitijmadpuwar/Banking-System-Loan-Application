package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoanEntity;
import com.example.demo.service.LoanService;

@RestController
public class LoanController  {

	@Autowired
	LoanService loanService;
	
	//======================= Apply for Loan =======================
	@PostMapping("/applyLoan")
	public void applyLoan() {
		
	}
	
	//======================= Apply for Gold Loan =======================
	 @PostMapping("/goldloan")
	    public ResponseEntity<LoanEntity> applyGoldLoan(@RequestBody LoanEntity loan) {
	        LoanEntity savedLoan = loanService.applyGoldLoan(loan);
	        return ResponseEntity.ok(savedLoan);
	    }
	
	//======================= Apply for BikeLoan =======================
	@PostMapping("/homeLoan")
	public void homeLoan() {
		
	}
	//======================= Apply for HomeLoan =======================
	@PostMapping("bikeLoan")
	public void bikeLoan() {
		
	}
}

