package com.slf.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;

public class BasketBallSort {

	private int[] ball;
	public int num;
	public BasketBallSort() {
		// TODO Auto-generated constructor stub
		getInput();
		initBall();
		sort(ball, 0, ball.length-1);
	}
	
	
	private void initBall() {
		// TODO Auto-generated method stub
		ball = new int[num];
		for(int i = 0; i < num; i++){
			ball[i] = i+1;
		}
	}


	private void sort(int[] buf, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end) {
			if (check(buf)) {
				for (int i = 0; i < buf.length; i++) {
					System.out.print(buf[i]+" ");
				}
				System.out.println();
			}
		}
		for (int i = start; i <= end; i++) {
			int temp = buf[start];
			buf[start]  = buf[i];
			buf[i] = temp;
			sort(buf, start+1, end);
			temp = buf[start];
			buf[start]  = buf[i];
			buf[i] = temp;
		}
	}

	private boolean check(int[] buf) {
		for (int i = 0; i < buf.length; i++) {
			if ((i+1) == buf[i]) {
				return false;
			}
			if (i < buf.length - 1) {
				if (Math.abs(buf[i] - buf[i+1]) == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private void getInput() {
		// TODO Auto-generated method stub
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		try {
			String string = in.readLine();
			num = Integer.parseInt(string);
			System.out.println(num);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BasketBallSort();
	}

}
