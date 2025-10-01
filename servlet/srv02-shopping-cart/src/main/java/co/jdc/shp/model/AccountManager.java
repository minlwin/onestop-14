package co.jdc.shp.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import co.jdc.shp.exceptions.BusinessException;

public class AccountManager implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String KEY = "AccountManager";
	
	private Map<String, Account> accounts = Collections.synchronizedMap(new HashMap<>());
	
	public void signUp(Account account) {
		
		if(null == account.getName() || account.getName().isBlank()) {
			throw new BusinessException("Please enter your name.");
		}
		
		if(null == account.getEmail() || account.getEmail().isBlank()) {
			throw new BusinessException("Please enter email.");
		}

		if(null == account.getPassword() || account.getPassword().isBlank()) {
			throw new BusinessException("Please enter password.");
		}
		
		if(accounts.containsKey(account.getEmail())) {
			throw new BusinessException("%s is already used.");
		}
		
		accounts.put(account.getEmail(), account);
	}
	
	public Account signIn(String username, String password) {
		
		var account = accounts.get(username);
		
		if(null == account) {
			throw new BusinessException("Please check your login id.");
		}
		
		if(!account.getPassword().equals(password)) {
			throw new BusinessException("Please check your password.");
		}
		
		return account;
	}

}
