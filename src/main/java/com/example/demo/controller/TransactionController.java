package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	 @GetMapping("/transaction/{accountNumber}")
	    public List<TransactionEntity> miniStatement(@PathVariable Long accountNumber) {
	        return transactionService.getMiniStatement(accountNumber);
	    }
}
