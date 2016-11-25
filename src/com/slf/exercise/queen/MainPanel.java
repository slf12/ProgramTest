package com.slf.exercise.queen;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	private TimePanel timePanel;
	private DrawPanel drawPanel;
	public MainPanel(DrawPanel panel) {
		// TODO Auto-generated constructor stub
		this.drawPanel = panel;
		setPreferredSize(new Dimension(800, 600));
		timePanel = new TimePanel();
		add(drawPanel);
		add(timePanel);
	}
}
