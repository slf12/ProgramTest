package com.slf.math;

import java.util.LinkedList;

public class Stack<T> {
	
	private LinkedList<T> data = new LinkedList<T>();
	public void push(T v){
		data.addFirst(v);
	}
	public boolean empty(){
		return data.isEmpty();
	}
	
	public T pop(){
		return data.removeFirst();
	}
	
	public int size(){
		return data.size();
	}
	
	public void print(){
		for(int i = 0; i < data.size(); i++){
			System.out.print(data.get(i) + "; ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<>();
		s.push("ss");
		s.push("ll");
		s.push("ff");
		s.print();
		s.pop();
		s.print();
		s.push("fffff");
		s.print();
	}

}
