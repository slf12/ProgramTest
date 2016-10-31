package com.slf.math;

public class BigInteger {
	
	public static String bigIntegerAdd(String s1, String s2){
		if (s1.isEmpty() ||  s1.equals("") || s2.isEmpty() || s2.equals("")) {
			return "0";
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
		if (s1.isEmpty() ||  s1.equals("") || s2.isEmpty() || s2.equals("")) {
			return "0";
		} else if (s1.equals("0")) {
			if (s2.startsWith("-")) {
				return s2.substring(1);
			}
		} else if (s2.equals("0")) {
			return s1;			
		}
		
		if (s1.startsWith("-")) {
			if (s2.startsWith("-")) {
				return bigIntegerSub(s2.substring(1), s1.substring(1));			
			} else {
				return "-" + bigIntegerAdd(s1.substring(1), s2);
			}
		} else {
			if (s2.startsWith("-")) {
				return bigIntegerAdd(s1, s2.substring(1));
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
		
		if (s1.compareTo(s2) < 0) {
			return "-" + bigIntegerSub(s2, s1);
		}
		int i,j;
		StringBuffer temp1 = new StringBuffer(s1);
		StringBuffer temp2 = new StringBuffer(s2);
		String result = "";
		for(i = s1.length() - 1; i > 0; i--){
			if (temp1.charAt(i) < temp2.charAt(i)) {
				j = 1;
				while (temp1.charAt(i - j) == '0') {
					temp1.setCharAt(i - j, '9');
				}
				temp1.setCharAt(i - j, (char)(temp1.charAt(i - j) - 1));
				result = (char)(temp1.charAt(i) + 10 - temp2.charAt(i)) + result;
			} else {
				result = (char)(temp1.charAt(i) + '0' - temp2.charAt(i)) + result;
				
			}
		}
		result = (char)(temp1.charAt(0) + '0' - temp2.charAt(0)) + result;
		for (i = 0; i < result.length(); i++) {
			if (result.charAt(i) != '0') {
				break;
			}
		}
		result = result.substring(i);
		if (result.equals("") || result.isEmpty()) {
			return "0";
		}
		return result;
	}
	
	public static String bigIntegerMul(String s1, String s2){
		if (s1.isEmpty() || s2.isEmpty() || s1.equals("") || s2.equals("")) {
			return "0";
		}
		
		if (s1.startsWith("-")) {
			if (s2.startsWith("-")) {
				return bigIntegerMul(s1.substring(1), s2.substring(1));
			} else {
				return "-" + bigIntegerMul(s1.substring(1), s2);
			}
		} else {
			if (s2.startsWith("-")) {
				return "-" + bigIntegerMul(s1, s2.substring(1));
			}
		}
		String temp1, temp2;
		if (s1.length() < s2.length()) {
			temp1 = s2;
			temp2 = s1;
		} else {
			temp1 = s1;
			temp2 = s2;
		}
		
		String result = "0";
		String temp = "";
		int i, j, n1, n2, n3, t;
		for(i = temp2.length() - 1; i >= 0; i--){
			temp  = "";
			n1 = n2 = n3 = 0;
			for(j = 0; j < temp2.length() - 1 - i; j++){
				temp = temp + "0";
			}
			n3 = temp2.charAt(i) - '0';
			for(j = temp1.length() - 1; j >=0; j--){
				t = (temp1.charAt(j) - '0') * n3 + n2;
				n1 = t % 10;
				n2 = t / 10;
				temp = (char)(n1 + '0') + temp;
			}
			if (n2 != 0) {
				temp = (char)(n2 + '0') + temp;
			}
			
			result = bigIntegerAdd(result, temp);
		}
		return result;
	}
	/*
	 * 大整数除法，flag = 1返回商， flag = 0返回余数	
	 */
	public static String bigIntegerDiv(String s1, String s2, int flag){
		String quotient, resiude;
		if (s2.equals("0")) {
			quotient = resiude = "error";
			if (flag == 1) {
				return quotient;
			} else {
				return resiude;
			}
		} 
		if (s1.equals("0")) {
			quotient = resiude = "0";
			if (flag == 1) {
				return quotient;
			} else {
				return resiude;
			}
		}
		
		int sign1, sign2;
		sign1 = sign2 = 1;
		if (s1.startsWith("-")) {
			sign1 *= -1;
			sign2 = -1;
			s1 = s1.substring(1);
		}
		if (s2.startsWith("-")) {
			sign1 *= -1;
			s2 = s2.substring(1);
		}
		
		if (s1.length() < s2.length() || s1.length() == s2.length() && s1.compareTo(s2) < 0) {
			quotient = "0";
			resiude = s1;
		} else if (s1.length() == s2.length() && s1.compareTo(s2) == 0) {
			quotient = "1";
			resiude = "0";
		}  else {
			//sign1 是商的符号， sign2是余数的符号
			quotient = resiude = "";
			StringBuffer temp = new StringBuffer();
			int size1, size2;
			size1 = s1.length();
			size2 = s2.length();
			int i;
			if (size2 > 1) {
				temp.append(s1, 0, size2 - 1);
			}
			
			for(i = size2 - 1; i < size1; i++){
				temp.append(s1.charAt(i));
				for(char c = '9'; c >= '0'; c--){
					String t = bigIntegerMul(s2, c+"");
					String s = bigIntegerSub(temp.toString(), t);
					if (s == "0" || s.charAt(0) != '-') {
						temp = new StringBuffer(s);
						quotient = quotient + c;
						break;
					}
				}
			}
			resiude = temp.toString();
		}
		quotient = rease0(quotient);
		resiude = rease0(resiude);
		
		if (sign1 == -1) {
			quotient = "-" + quotient;
		}
		
		if (sign2 == -1) {
			if (resiude.isEmpty()) {
				resiude = "0";
			} else {
				resiude = "-" + resiude;
			}
		}
		if (flag == 1) {
			return quotient;
		}
		return resiude;
	}
	
	public static String rease0(String s){
		int i = 0;
		for(i = 0; i < s.length(); i++){
			if (s.charAt(i) != '0') {
				break;
			}
		}
		s = s.substring(i);
		if (s.isEmpty() || s.equals("")) {
			return "0";
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BigInteger.bigIntegerDiv("99999999", "33", 1));
		System.out.println("1234".compareTo("12"));
	}

}
