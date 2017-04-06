package com.rex.web.formbean;



import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;



public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private Map errorsMap =new HashMap();
	
	
	
	public Map getErrorsMap() {
		return errorsMap;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	//username can't null and 3-8 char
	//password can't null and 3-8 char
	//password2 must the same of password
	//email can't null and must legal
	//birthday can null. if not null must digits
	public boolean Validate(){
		
		boolean isOK =true;
		
		if(this.username == null || this.username.trim().equals("")){
			isOK =false;
			errorsMap.put("username", "Username can't null");
		}else {
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK =false;
				errorsMap.put("username", "username must 3-8 character");
			}
		}
		
		if(this.password == null || this.password.trim().equals("")){
			isOK =false;
			errorsMap.put("password", "password can't null");
		}else {
			if(!this.password.matches("\\d{3,8}")){
				isOK =false;
				errorsMap.put("password", "password must 3-8 character");
			}
		}
		
		
		if(this.password2 == null || this.password2.trim().equals("")){
			isOK =false;
			errorsMap.put("password2", "password2 can't null");
		}else {
			if(!this.password .equals(this.password2)){
				isOK =false;
				errorsMap.put("password2", "password2 must the same of password");
			}
		}
		
		if(this.email == null || this.email.trim().equals("")){
			isOK =false;
			errorsMap.put("email", "email can't null");
		}else {
			if(!this.email.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)")){
				isOK =false;
				errorsMap.put("email", "email format incorrect");
			}
		}
		
		if(this.birthday!=null && !this.birthday.trim().equals("")){
			
			try {
				DateLocaleConverter date = new DateLocaleConverter(Locale.CHINESE);
				date.convert(this.birthday);
			} catch (Exception e) {
				isOK = false;
				errorsMap.put("birthday","birthday date illegality");
			}	
		}
		return  isOK;
	}
}
