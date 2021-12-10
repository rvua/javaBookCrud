package com.codingdojo.pokebook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.expenseService;

@Controller
public class HomeController {
	
	@Autowired
	expenseService expenseServ;
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("expenses", expenseServ.allExpenses());
		return "dashboard.jsp";
	}
	
	// Renders the form to make an Expense
	@RequestMapping("/newExpense")
	public String newExpense(@ModelAttribute("expense") Expense expense) {
		return "newExpense.jsp";
	}
	
	// Makes a method to create Expense 
	@RequestMapping("/processExpense")
	public String processExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "newExpense.jsp";
		}
		expenseServ.create(expense);
		return "redirect:/dashboard";
	}
	
	// To show an expense
	@RequestMapping("/oneExpense/{id}")
	public String viewExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseServ.oneExpense(id));
		return "oneExpense.jsp";
	}
	
	// Render form to edit expense
	@RequestMapping("/editExpense/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseServ.oneExpense(id);
		model.addAttribute("expense", expense);
		return "editExpense.jsp";
	}
	
	// Method to edit expense
	@RequestMapping(value="/editExpense/{id}", method=RequestMethod.PUT)
	public String editingExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "editExpense.jsp";
		}
		else {
			expenseServ.updateExpense(expense);
			return "redirect:/dashboard";
		}
	}
	
	// Delete expense
	@RequestMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/dashboard";
	}
	
}
