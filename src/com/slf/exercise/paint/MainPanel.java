package com.slf.exercise.paint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainPanel extends JPanel implements ActionListener{

	public  MainPanel() {
		// TODO Auto-generated constructor stub
		super(new BorderLayout());
		JToolBar jToolBar = new JToolBar("tool bar");
		addButtons(jToolBar);
		setPreferredSize(new Dimension(600, 600));
		add(jToolBar, BorderLayout.PAGE_START);
	}
	
	public void addButtons(JToolBar toolBar){
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
