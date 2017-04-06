package com.rex.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class ServiceUtils {
	public static String md5(String message){
	
		try {
			MessageDigest mDigest =MessageDigest.getInstance("md5");
			byte md5[]=mDigest.digest(message.getBytes());
			
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
