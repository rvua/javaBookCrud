package com.codingdojo.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.repositories.expenseRepository;

@Service
public class expenseService {
	
	@Autowired
	expenseRepository expenseRepo; 
	
	// See all expenses
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	// Create Expense
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	// Find one expense
	public Expense oneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}	
	}
	
	// Delete Expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id); 
	}
	
	
	// Update expense
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
}
