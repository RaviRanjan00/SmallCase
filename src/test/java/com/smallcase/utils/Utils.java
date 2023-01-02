package com.smallcase.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.smallcase.testCases.BaseClass;

public class Utils extends BaseClass {

	 public static boolean isDate(String A)
	    {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        format.setLenient(false);
	        try {
	            format.parse(A);
	            return true;
	        } catch (ParseException e) {
	            System.out.println("Date " + A + " is not valid according to " +format.toPattern() + " pattern.");
	            return false;
	        }
	    }
	    public static boolean isInteger(String Page) {
	        System.out.println(String.format("Parsing string: \"%s\"", Page));

	        if(Page == null || Page.equals("")) {
	            System.out.println("String cannot be parsed, it is null or empty.");
	            return false;
	        }

	        try {
	            int intValue = Integer.parseInt(Page);
	            return true;
	        } catch (NumberFormatException e) {
	            System.out.println("Input String cannot be parsed to Integer.");
	        }
	        return false;
	    }
	    
	    public static boolean isChar(String name)
	    {
	        name = name.replaceAll("\\s", "").replaceAll(".", "");
	        char[] chars = name.toCharArray();

	        for (char c : chars) {
	            if(!Character.isLetter(c)) {
	                return false;
	            }
	        }

	        return true;
	    }
	    
	    public static boolean isLink(String website)
	    {
	    	if(website.contains("http://") || website.contains("https://"))
	    	{
	    		System.out.println("website is having link");
	    		return true;
	    	}
	    	else
	    		System.out.println("website is not having link");
	    		return false;
	    
	    }

}

