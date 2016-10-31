package com.slf.exercise;

import java.util.Scanner;

import com.slf.math.BigInteger;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("please input n (n >= 1)");
		Scanner scr = new Scanner(System.in);
		Long input = scr.nextLong();
		String result = "0";
		for(int i = 1; i <= input; i++){
			String temp = "1";
			for(int j = 1; j <= i; j++){
				temp = BigInteger.bigIntegerMul(temp, i+"");
			}
			result = BigInteger.bigIntegerAdd(result, temp);
		}
		
		System.out.println(result);
	}

}
