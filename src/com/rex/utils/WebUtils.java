package com.rex.utils;


import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> formBean){
		//creat formbean
		try {
			T bean = formBean.newInstance();
			
		//get data from request and set to formbean	
			Enumeration e = request.getParameterNames();
			
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement(); // username
				String value= request.getParameter(name); // username value
				
				System.out.println(name);
				System.out.println(value);
				BeanUtils.setProperty(bean, name, value);
			}
			
			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}
	
	
	/*		private String id ;
	private String username;
	private String password;
	private String email;
	private String birthday;
	private String nickname;*/
	
/*		private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;*/
	
	public static void copyBean(Object src, Object dest){
		
		try {
			BeanUtils.copyProperties(dest,src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// get unique number in world
	public static String generateID(){
		return UUID.randomUUID().toString();
	}

}
