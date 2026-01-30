package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepository;
	
	//===================== Apply for loan ==============================
	public void applyLoan() {
		
		//Check Login or Sign-Up
		//Check Exiting Account.
		//Minimum balance Check
		
		// Type of Loan and Calculate intrested
		
		// Other Actice Loan
		
		
	}
}
