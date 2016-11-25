package com.slf.exercise.queen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	private Queens queens;
	public DrawPanel(Queens queens) {
		// TODO Auto-generated constructor stub
		this.queens = queens;
		setPreferredSize(new Dimension(600, 600));
		addMouseListener(new MyMouseListener());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawLine(g2d);
		drawQueen(g2d);
		
	}
	
	private void drawQueen(Graphics2D g2d) {
		// TODO Auto-generated method stub
		for(int i = 0; i <8; i++){
			for(int j = 0; j < 8; j++){
				if (queens.getQueen()[i][j] && i == queens.conflictRow && j == queens.confictCol) {
					g2d.setColor(Color.red);
					g2d.fillOval(100 + j*50, 50 + i*50, 50, 50);
				} else if (queens.getQueen()[i][j]) {
					
					g2d.setColor(Color.black);
					g2d.fillOval(100 + j*50, 50 + i*50, 50, 50);
				}
			}
		}
	}

	private void drawLine(Graphics2D graphics2d){
		for(int i = 0; i < 9; i++){
			graphics2d.drawLine(i*50 + 100, 50, i*50 + 100, 450);
			graphics2d.drawLine(100, i*50+50, 500, i*50 + 50);
		}
			
	}
	
	
	public void  showMessage() {
		
		JOptionPane.showMessageDialog(this, "位置不合法");
	
	}
	
	public void showWinMessage(){
		
	}
	
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int x = arg0.getX() - 100;
			int y = arg0.getY() - 50;
			queens.setTempRow(y / 50);
			queens.setTempCol(x / 50);
			queens.getQueen()[y / 50][x / 50] = true;
			repaint();
			if (queens.check(y / 50, x / 50)) {
				if (queens.checkWin()) {
					showWinMessage();
				}
				return;
			} else {
				showMessage();
				repaint();
				queens.confictCol = -1;
				queens.confictCol = -1;
				queens.getQueen()[y / 50][x / 50] = false;
				repaint();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
