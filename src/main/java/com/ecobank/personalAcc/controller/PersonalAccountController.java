package com.ecobank.personalAcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecobank.personalAcc.model.PersonalAccounts;
import com.ecobank.personalAcc.repository.PersonalAccountRepo;
import com.ecobank.personalAcc.repository.repoImpl.PersonalAccRepoImpl;
import com.ecobank.personalAcc.utils.ResponseUtils;

@RestController
@RequestMapping("/accountenquiry")
public class PersonalAccountController {

//	PersonalAccounts personalAcc= new PersonalAccounts();
	@Autowired
	private PersonalAccountRepo personalAccountRepo;
	
	@Autowired
	private ResponseUtils responseUtils;

	@Autowired
	private PersonalAccRepoImpl custAccount;

	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<?> getPersonalAccount(@PathVariable String accountNumber) {

		List<PersonalAccounts> accountList = custAccount.getPersonalAccount(accountNumber);
		
		
		
		
		
		 if (accountList !=null && accountList.size()> 0) {
	        	return responseUtils.getResponse( "00", "Fetch Successfully", accountList);
	        }
	        	return responseUtils.getResponse("99", "No record found.");
	        }

	

}
