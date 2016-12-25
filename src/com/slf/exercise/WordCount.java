package com.slf.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sanglf
 *
 */
public class WordCount {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一句话:");
		String text = scanner.nextLine();
		
		String[] words = text.split("[ ,.?!]");
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.get(words[i]) == null) {
				map.put(words[i], 1);
			} else {
				int value = map.get(words[i]).intValue();
				value++;
				map.put(words[i], value);
			}
		}
		
		ArrayList arrayList = new ArrayList<>(map.entrySet());
		
		Collections.sort(arrayList, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			public int compare(Object obj1, Object obj2){
				Map.Entry<String, Integer> en1 = (Map.Entry<String, Integer>) obj1;
				Map.Entry<String, Integer> en2 = (Map.Entry<String, Integer>) obj2;
				return (Integer) en2.getValue().compareTo((Integer) en1.getValue());
				
			}
		});
        System.out.println(arrayList);
	}

}
