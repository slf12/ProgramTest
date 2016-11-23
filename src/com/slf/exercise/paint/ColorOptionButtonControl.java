package com.slf.exercise.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorOptionButtonControl extends JPanel{
	private JButton button1;
	private JPanel panel1;
	private JButton button2;
	private JPanel panel2;
	private ToolBoxPanel toolBoxPanel;
	
	public ColorOptionButtonControl(ToolBoxPanel toolBoxPanel){
		button1 = new JButton("pen color");
		button2 = new JButton("brush color");
		panel2 = new JPanel();
		panel1 = new JPanel();
		this.toolBoxPanel = toolBoxPanel;
		buildGUI();
	}
	
	public void setColor(Color color) {
		if (panel1.getBackground() == Color.gray) {
			button1.setBackground(color);
			toolBoxPanel.setCurrentPenColor(color);
		} else {
			button2.setBackground(color);
			toolBoxPanel.setCurrentBrushColor(color);
		}
	}

	private void buildGUI() {
		// TODO Auto-generated method stub
		panel1.setPreferredSize(new Dimension(150, 100));
		panel2.setPreferredSize(new Dimension(150, 100));
		
		button1.setPreferredSize(new Dimension(100,50));
		button2.setPreferredSize(new Dimension(100, 50));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (panel1.getBackground() != Color.gray){
					panel1.setBackground(Color.gray);
					panel2.setBackground(null);
				}
			}
		});
		
		panel1.add(button1);
		panel1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				panel1.setBackground(Color.gray);
				panel2.setBackground(null);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (panel2.getBackground() != Color.gray) {
					panel2.setBackground(Color.gray);
					panel1.setBackground(null);
				}
			}
		});
		
		panel2.add(button2);
		panel2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				panel1.setBackground(Color.gray);
				panel2.setBackground(null);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(panel1);
		add(panel2);
	}
}
