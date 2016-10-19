package com.aoplog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.annotation.LogInfo;

@Aspect
@Component
public class LogAspect {
	@Around(value="execution(* com.aoplog.AService.*(..)) && @annotation(log)")
	public Object doAround(ProceedingJoinPoint pjp, LogInfo log) throws Throwable{
		Long time = System.currentTimeMillis();
		Object obj = pjp.proceed();
		time = System.currentTimeMillis()-time;
		System.out.println("process time:"+time+"ms");
		return obj;
	}
	
}
