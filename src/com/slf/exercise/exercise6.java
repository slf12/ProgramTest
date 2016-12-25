package com.slf.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exercise6 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入n个数，以空格隔开");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			input = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] num_str = input.split(" ");
		int n = num_str.length;
		int[] nums = new int[n];
		for (int i = 0; i < num_str.length; i++) {
			nums[i] = Integer.parseInt(num_str[i]);
		}
		
		int b[] = new int[n];
		b[n-1] = nums[0];
		b[n-2] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				int add1 = b[j+1];
				int add2 = b[j] * nums[i];
				b[j] = add1 + add2;
			}
			b[n-1] = b[n-1] * nums[i];
		}
		
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

}
