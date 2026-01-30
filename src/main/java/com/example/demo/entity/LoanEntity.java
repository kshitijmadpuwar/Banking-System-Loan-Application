package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanEntity {

	
  //	private SignUp signUp;

	// @OneToOne(mappedBy = "apply", cascade = CascadeType.ALL)
	//private CibilScore cibilScore;

	// Applicant Information
	private String applicantName;
	private String mobileNumber;
	private String email;
	private String occupation;
	private String designation;
	private double salary;

	// Company Information
	private String companyName;
	private String companyEmail;
	private String companyAddress;

	// Address Information
	private String currentAddress;
	private String permanentAddress;

	// Salary and Income Detail
	private double annualSalary;
	private double monthlyIncome;
	private String occupationType;
	private String employerNumber;

	// Loan Detail
	private double loanAmountRequired;
	private int loanTenure;

	// Property Detail
	private String propertyType;
	private String propertyLocation;
	private double propertyValue;
}
