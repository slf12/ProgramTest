package com.slf.exercise.paint;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Exercise3 {

	private static void createAndShowGUI(){
		JFrame jFrame = new JFrame("»­Í¼³ÌÐò");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.setSize(800, 800);
		
		
		//jFrame.pack();
		jFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createAndShowGUI();
			}
		});
	}

}
