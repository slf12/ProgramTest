package com.slf.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Exercise3 {
	
	public static void stringCoount(String input) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner( System.in);
		System.out.println("请输入字符串，以#分隔，以.结束");
		String input = scanner.nextLine();
		input = input.substring(0, input.indexOf('.'));
		scanner.close();
		int max = 0, min = Integer.MAX_VALUE;
		String max_str = "", min_str = "";
		String[] array = input.split("#");
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > max) {
				max = array[i].length();
				max_str = array[i];
			}
			if (array[i].length() < min) {
				min = array[i].length();
				min_str = array[i];
			}
			list.add(array[i]);
		}
		System.out.println("字符串个数为：" + array.length);
		System.out.println("最长字符串为: "+ max_str + ", 字符个数为：" + max);
		System.out.println("最短字符串为: "+ min_str + ", 字符个数为：" + min);
		
		Collections.sort(list);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
			for(int i = 0; i < list.size(); i++){
				writer.write(list.get(i) + "\n");
			}
			writer.write("字符串个数为：" + array.length);
			writer.write("最长字符串为: "+ max_str + ", 字符个数为：" + max);
			writer.write("最短字符串为: "+ min_str + ", 字符个数为：" + min);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

}
