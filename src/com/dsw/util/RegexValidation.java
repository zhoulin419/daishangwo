package com.dsw.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 使用正则表达式验证输入格式
 */
public class RegexValidation {
	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		boolean flag = false;
		try{
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}

	/**
	 * 验证密码是否一致
	 * @param password, conformPassword
	 * @return
	 */
	public static boolean checkPassword(String password, String conformPassword){
		boolean flag = false;
		if(password.equals(conformPassword)){
			flag = true;
		}
		return flag;
	}
}