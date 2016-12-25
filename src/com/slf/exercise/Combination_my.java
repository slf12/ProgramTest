package com.slf.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination_my {

	public static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 	1;
		}
		return n * factorial(n - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combination(5, 3);
	}
	
	public int getNum(){
		BufferedReader reader = new  BufferedReader(new  InputStreamReader(System.in));
		try {
			String string = reader.readLine();
			int num = Integer.parseInt(string);
			return num;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void combination(int n, int r) {
		int c_n_r = factorial(n)/(factorial(r) * factorial(n - r));
		System.out.println("共有"+ c_n_r +"种组合");
		if (c_n_r != 0) {
			int[] result = new int[r + 1];
			for(int i = 1; i <= r; i++){
				result[i] = i;
			}
			for (int i = 1; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			
			for(int i = 2; i <= c_n_r; i++){
				int  m = r; 
				int max_val = n;
				while(result[m] == max_val){
					m--;
					max_val --;
				}
				result[m] = result[m] + 1;
				for(int j = m + 1; j <= r; j++){
					result[j] = result[j-1] + 1;
				}
				for (int k = 1; k < result.length; k++) {
					System.out.print(result[k] + " ");
				}
				System.out.println();
				
			}
 		}
	}
}
