package com.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.PersonServer;
import com.aoplog.AService;
import com.aspect.UserService;

public class TestCase {
	 @Test
     public void inteceptorTest(){  
         ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");      
         PersonServer bean = ctx.getBean("personServerImpl",PersonServer.class);  
         bean.save("badMonkey",23);  
	 }
	 
	 @Test
	 public void test(){
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		 UserService service = ctx.getBean("userServiceImpl",UserService.class);
		 service.add();
	 }
	 
	
	 
}





