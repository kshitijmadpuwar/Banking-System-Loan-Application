package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
     //	private SignUp signUp;

	// @OneToOne(mappedBy = "apply", cascade = CascadeType.ALL)
	//private CibilScore cibilScore;

	// Applicant Information
	private String applicantName;
	private String mobileNumber;
	private String email;
	private String occupation;
	private String designation;
	private Double salary;
	
	// Account Details
	private Double accNumber;

	// Company Information
	private String companyName;
	private String companyEmail;
	private String companyAddress;

	// Address Information
	private String currentAddress;
	private String permanentAddress;

	// Salary and Income Detail
	private Double annualSalary;
	private Double monthlyIncome;
	private String occupationType;
	private String employerNumber;

	// Loan Detail
	private Double loanAmountRequired;
	private Integer loanTenure;

	// Property Detail
	private String propertyType;
	private String propertyLocation;
	private Double propertyValue;
	
	//Type of Loan 
	private String loanType;
	
	//Gold Details 
	private String goldType;
	private String purity;
	private Double netWeight;
	private Double goldRate;
	private Double totalValue;
	
	//Bike Details
	private String brand ;
	private String Model;
	private Double onRoadPrice;
	private String chassisNo;
	
	
}
