package com.slf.exercise.paint;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Exercise3 extends JFrame{

	public Exercise3(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("»­Í¼³ÌÐò");
		setContentPane(new MainPanel());
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Exercise3();
			}
		});
	}

}
