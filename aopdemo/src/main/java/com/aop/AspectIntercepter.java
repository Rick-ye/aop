package com.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectIntercepter {
	
	
	@Pointcut(value="execution(* com.aop.PersonServerImpl.*(..))")
	public void pointCut(){}
	
	/*
	 * 环绕通知
	 */
	@Around(value="pointCut()")
	public Object doBasic(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("@Around进入环绕通知；");
		Object obj = pjp.proceed();
		System.out.println(pjp.getThis()+"退出环绕方法，方法运行结束");
		return obj;
	}
	
	/*
	 * 前置通知
	 */
	@Before(value="pointCut()")
	public void doAccessCheck(JoinPoint jp){
		System.out.println("@Before前置通知："+Arrays.toString(jp.getArgs()));
	}
	/*
	 * 异常通知（出错时执行）
	 */
	@AfterThrowing(value="pointCut()",throwing="ex")
	public void doAfterThrow(JoinPoint jp, Throwable ex){
		System.out.println("@AfterThrowing例外通知(异常通知)"+Arrays.toString(jp.getArgs()));  
        System.out.println("@AfterThrowing异常信息："+ex);
	}
	
	@After(value="pointCut()")
	public void after() {
		System.out.println("after后置通知。。");
	}
	
	@AfterReturning(value="pointCut()")
	public void doAfter(){
		System.out.println("doafter最终通知..end;");
	}
}







