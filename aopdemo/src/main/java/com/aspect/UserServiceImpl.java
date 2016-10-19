package com.aspect;

import com.annotation.LogAnotationIN;

public class UserServiceImpl implements UserService {
	
	@LogAnotationIN(desc="this is UserService")
	public void add(){
		System.out.println("UserService add()...");
	}
	
}
