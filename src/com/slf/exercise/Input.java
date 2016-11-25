package com.slf.exercise;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class Input {
	
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String string;
		StringBuffer sBuffer = new StringBuffer();
		while((string = in.readLine()) != null)
			sBuffer.append(string);
		in.close();
		return sBuffer.toString();
	}
	
	public static void  memoryInput() throws IOException{
		StringReader in = new StringReader(read("Input.java"));
		int c;
		while((c = in.read()) != -1)
			System.out.println((char)c);
		in.close();
	}

	public static void formattedMemoryInput() throws IOException{
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(read("Input.java").getBytes()));
		while(true)
			System.out.println((char)in.readByte());
	}
	
	
	public void echo() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String string;
		while((string = stdin.readLine()) != null && string.length() != 0){
			System.out.println(string);
		}
		stdin.close();
	}
	
	public void basicFileOutput() throws IOException{
		String file = "BasicFileOutput.out";
		BufferedReader in = new BufferedReader(new StringReader(read("Input.java")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null)
			out.println(lineCount++ + ": " + s);
		out.close();
	}
	public void testEOF() throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Input.java")));
		while(in.available() != 0)
			System.out.println((char)in.readByte());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
