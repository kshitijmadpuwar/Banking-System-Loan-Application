package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoanEntity;
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
	//==================== Home  loan ========================================
	//==================== Bike loan ========================================
	//==================== Gold loan ========================================
	public LoanEntity applyGoldLoan(LoanEntity loan ) {
	
		//check Account exist
		
		
		    // -----------------------------
            // 2. Common eligibility checks
            // -----------------------------
		   if(loan.getMonthlyIncome() == null || loan.getMonthlyIncome() < 15000) {
	            throw new IllegalArgumentException("Monthly income too low for loan eligibility");
	        }

	        if(loan.getLoanAmountRequired() == null || loan.getLoanAmountRequired() <= 0) {
	            throw new IllegalArgumentException("Invalid loan amount");
	        }

	        if(loan.getLoanTenure() == null || loan.getLoanTenure() <= 0) {
	            throw new IllegalArgumentException("Invalid loan tenure");
	        }
	        // -----------------------------
	        // 3. Gold loan specific checks
	        // -----------------------------
	        if(loan.getNetWeight() == null || loan.getGoldRate() == null) {
	            throw new IllegalArgumentException("Gold weight and gold rate are required");
	        }

	        double goldValue = loan.getNetWeight() * loan.getGoldRate();

	        if(loan.getLoanAmountRequired() > goldValue * 0.75) {
	            throw new IllegalArgumentException("Loan exceeds 75% of gold value");
	        }

	        // check CIVIL Score //
	        
	        // -----------------------------
	        // 4. Set loan type and save
	        // -----------------------------
	        loan.setLoanType("gold");

	        return loanRepository.save(loan);
	}
}
