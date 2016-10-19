package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.annotation.LogAnotationIN;

@Aspect
@Component
public class LogAnnotation {
	@Around(value="execution(* com.aspect.UserService.*(..)) && @annotation(la)")
	public Object arMethod(ProceedingJoinPoint pjp, LogAnotationIN la) throws Throwable{
		Object result = null;
		System.out.println(la.desc());
		//System.out.println("前置通知");
		long time = System.currentTimeMillis();
		result = pjp.proceed();
		time = System.currentTimeMillis()-time;
		System.out.println(time);
		
		//System.out.println("后置通知");
		//System.out.println("返回通知");
		return result;
		
	}
}
