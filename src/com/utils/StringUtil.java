package com.utils;

public class StringUtil {

	
	public static  boolean isBlank(String  testString)
	{
		if(testString == null || testString.trim().length() == 0 || "null".equalsIgnoreCase(testString)){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean  isBlank(String  testString1, String testString2){
		return isBlank(testString1) || isBlank(testString2);
	}
	
	public static boolean  isBlank(String  testString1, String testString2 ,String testString3){
		return isBlank(testString1) || isBlank(testString2) || isBlank(testString3);
	}
	
	public static boolean  isBlank(String  testString1, String testString2, String testString3, String testString4){
		return isBlank(testString1) || isBlank(testString2)|| isBlank(testString3)|| isBlank(testString4);
	}
	
	
	public static boolean  isNotBlank(String testString) 
	{
		return  !isBlank(testString);
	}
	
	public static boolean  isNotBlank(String  testString1, String testString2) 
	{
		return  isNotBlank(testString1) && isNotBlank(testString2);
	}
	
	public static boolean  isNotBlank(String  testString1, String testString2, String testString3) 
	{
		return  isNotBlank(testString1) && isNotBlank(testString2)&& isNotBlank(testString3);
	}
	
	public static boolean  isNotBlank(String  testString1, String testString2, String testString3, String testString4) 
	{
		return  isNotBlank(testString1) && isNotBlank(testString2)&& isNotBlank(testString3)&& isNotBlank(testString4);
	}
	
}
