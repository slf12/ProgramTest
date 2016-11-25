package com.slf.exercise.queen;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Queen extends JFrame{
	
	private DrawPanel drawPanel;
	private Queens queens;
	public Queen() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 800));
		setTitle("°Ë»Êºó");
		queens = new Queens();
		drawPanel = new DrawPanel(queens);
		setContentPane(new MainPanel(drawPanel));
		pack();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Queen();
			}
		});
	}

}
