package com.aaron.aaronworld.base.interceptor;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志拦截器
 * 
 * @author Aaron
 * @date 2017年12月12日
 *
 * @since 0.0.1
 */
@Component
@Aspect
public class LogInterceptor {

	/**
	 * 获取服务方法
	 * 
	 * @author andy
	 * @date 2016年12月12日
	 *
	 * @since 0.0.1
	 */
	@Pointcut("execution(* com.aaron.aaronworld.service.impl..*.*(..))")
	public void getServiceMethod() {
	}

	/**
	 * 服务方法执行前
	 * 
	 * @author andy
	 * @date 2016年12月12日
	 *
	 * @since 0.0.1
	 */
	@Before("getServiceMethod()")
	public void serviceMethodBefore(JoinPoint joinPoint) {
		String classType = joinPoint.getTarget().getClass().getName();
		try {
			Class<?>  clazz = Class.forName(classType);
			String clazzName = clazz.getName();
			String methodName = joinPoint.getSignature().getName();
			String args = Arrays.toString(joinPoint.getArgs());

			Logger logger = LoggerFactory.getLogger(clazzName);
			String message = ">>> "+methodName+"(String...) start";
			message = message.replace("String...", args.substring(1, args.length()-1));
			logger.debug(message);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 服务方法执行后
	 * 
	 * @author andy
	 * @date 2016年12月12日
	 *
	 * @since 0.0.1
	 */
	@After("getServiceMethod()")
	public void serviceMethodAfter(JoinPoint joinPoint) {
		String classType = joinPoint.getTarget().getClass().getName();
		try {
			Class<?>  clazz = Class.forName(classType);
			String clazzName = clazz.getName();
			String methodName = joinPoint.getSignature().getName();
			String args = Arrays.toString(joinPoint.getArgs());

			Logger logger = LoggerFactory.getLogger(clazzName);
			String message = "<<< "+methodName+"(String...) end";
			message = message.replace("String...", args.substring(1, args.length()-1));
			logger.debug(message);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
