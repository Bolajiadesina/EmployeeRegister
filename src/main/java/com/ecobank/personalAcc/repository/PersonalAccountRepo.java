package com.ecobank.personalAcc.repository;

import java.util.List;

import com.ecobank.personalAcc.model.PersonalAccounts;

public interface PersonalAccountRepo {
	
	
	List <PersonalAccounts> getPersonalAccount (String accountNumber);

}
