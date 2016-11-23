package com.slf.exercise.paint;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
	private DrawPanel drawPanel;
	private ToolBoxPanel toolBoxPanel;
	
	public MainPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		buildGui();
	}
	
	private void buildGui(){
		toolBoxPanel = new ToolBoxPanel();
		drawPanel = new DrawPanel(toolBoxPanel);
		add(toolBoxPanel);
		add(drawPanel);
	}
}