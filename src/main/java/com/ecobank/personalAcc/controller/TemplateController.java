package com.ecobank.personalAcc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecobank.personalAcc.model.Account;
import com.ecobank.personalAcc.model.PersonalAccounts;
import com.ecobank.personalAcc.repository.repoImpl.PersonalAccRepoImpl;

@Controller
@RequestMapping("/account")
public class TemplateController {
	
	@Autowired
	PersonalAccRepoImpl personalAccountRepoImpl;

	@GetMapping("/qas")
	public String AccountEnquiry(Model model) {
		model.addAttribute("customerNumber", new ArrayList<PersonalAccounts>());

		return "ViewFile";
	}		
	@RequestMapping(value = "/qas", method = RequestMethod.POST)
	public String AccountEnquiry(Model model, Account account) {
		//Account account;
		//String accountNumber = null;
		model.addAttribute("personalAccounts", personalAccountRepoImpl.getPersonalAccount(account.getAccountNumber()));
		//System.out.println(account.getAccountNumber());
		//model.addAttribute("customerNumber", personalAccount.responseMessage);

		return "ViewFile";
	}

}
