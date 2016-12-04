package com.sasi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sasi.service.CustomerService;


@Controller
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/deleteUser/{value}", method=RequestMethod.GET)
	public ModelAndView removeUser(@PathVariable("value") String value){
				
		List<String> list = getList();
		List<String> dept = getDept();
		list.remove(Integer.parseInt(value));
		dept.remove(Integer.parseInt(value));
		
		ModelAndView model = new ModelAndView("HomePage");
		model.addObject("lists", list);
		model.addObject("departments", dept);
		
		return model;
			
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm(){
		
		return "login";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView verifyLogin(@RequestParam String userId,@RequestParam String password){
		ModelAndView model;
		Boolean loginStatus = customerService.loginCustomer(userId,password);		
		if(loginStatus==true){
			List<String> list = getList();
			List<String> dept = getDept();
			model = new ModelAndView("HomePage");
			model.addObject("lists", list);
			model.addObject("departments", dept);
		}
		else
		{
			model = new ModelAndView("login");
			model.addObject("status", "Login Failure");
			
		}		
		
		return model;
			
	}
	
	
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("Tony");
		list.add("Rich");
		list.add("John");
		list.add("Mike");
		

		return list;

	}
	
	private List<String> getDept() {

		List<String> list = new ArrayList<String>();
		list.add("Retail");
		list.add("Business");
		list.add("Retail");
		list.add("Business");
		

		return list;

	}
	
	
}
