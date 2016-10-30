package com.slf.math;

public class BigInteger {
	
	public static String bigIntegerAdd(String s1, String s2){
		if (s1.isEmpty() || s2.isEmpty()) {
			return null;
		} else if (s1.equals("0")) {
			return s2;
		} else if (s2.equals("0")) {
			return s1;			
		}
		
		if (s1.startsWith("-")) {
			if (s2.startsWith("-")) {
				return "-" + bigIntegerAdd(s1.substring(1), s2.substring(1));			
			} else {
				return bigIntegerSub(s2, s1);
			}
		} else {
			if (s2.startsWith("-")) {
				return bigIntegerSub(s1, s2);
			}
		}
		
		int size1 = s1.length();
		int size2 = s2.length();
		if (size1 < size2) {
			for(int i = 0; i < size2 - size1; i++){
				s1 = "0" + s1;
			}
		} else {
			for(int i = 0; i < size1 - size2; i++){
				s2 = "0" + s2;
			}
		}
		int p = 0;
		int q = 0;
		String result = "";
		for(int i = s1.length() - 1; i >=0; i--){
			p = (s1.charAt(i) - '0' + s2.charAt(i) - '0' + q) % 10;
			q = (s1.charAt(i) - '0' + s2.charAt(i) - '0' + q) / 10;
			result = (char)( p + '0') + result;
		}
		
		if (q == 1) {
			result = "1" + result;
		}
		
		return result;
	}
	
	public static String bigIntegerSub(String s1, String s2){
		
		return "";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BigInteger.bigIntegerAdd("-127899999999", "-123"));
	}

}
