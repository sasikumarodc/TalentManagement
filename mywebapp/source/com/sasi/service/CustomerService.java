package com.sasi.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	
	public boolean loginCustomer(String userId,String password){
		if(userId.equals("admin") && password.equals("admin")){
			return true;	
		}
		else if(userId.equals("lead") && password.equals("lead")){
			return true;
		}
		else
		return false;
	}
}
