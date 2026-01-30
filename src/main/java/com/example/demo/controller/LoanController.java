package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoanService;

@RestController
public class LoanController  {

	@Autowired
	LoanService loanService;
	
	//======================= Apply for Loan =======================
	@PostMapping("/applyLoan")
	public void applyLoan() {
		
	}
}
