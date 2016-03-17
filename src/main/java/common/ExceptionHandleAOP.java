package common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExceptionHandleAOP {
	
	@Pointcut("execution(* *.*(..))")
	public void exceptionHandler(){}
	
	@AfterThrowing(pointcut="exceptionHandler()",throwing = "e")
	public void doAfterThrowException(Exception e){
		
	}

}
