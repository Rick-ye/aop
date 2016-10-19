package com.aop;

public class PersonServerImpl implements PersonServer {

	public void save(String name, int age) {

		int a=1;  
        age= age/a;//打开上面两行报错，可触发异常通知  
        System.out.println("come in personServerImpl save method..."); 
	}
	
}
