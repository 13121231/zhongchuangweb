package cn.edu.njupt.bigdata.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	private static Pattern pattern = null;
	
	public static boolean matchEMail(String email) {
		pattern = Pattern.compile("\\w{3,20}@\\w+\\.(com|org|cn|net|gov)");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean matchTelephone(String telephone) {
		pattern = Pattern.compile("\\d{11}");
		Matcher matcher = pattern.matcher(telephone);
		return matcher.matches();
	}

}
