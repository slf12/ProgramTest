package com.slf.exercise.othello;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OthelloWindow extends JFrame{
	
	public OthelloWindow() {
		// TODO Auto-generated constructor stub
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 800));
		setTitle("Othello");
		setContentPane(new MainPanel());
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				new OthelloWindow();
			}
		});
	}

}
