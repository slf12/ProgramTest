package com.slf.exercise.othello;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	private Board board;
	private JLabel blackLabel;
	private JLabel whiteLabel;
	private JLabel currentUser;
	public BoardPanel(Board board, JLabel whiteLabel, JLabel blackLabel, JLabel currentUser) {
		// TODO Auto-generated constructor stub
		super();
		this.board = board;
		setPreferredSize(new Dimension(401, 401));
		this.blackLabel = blackLabel;
		this.currentUser = currentUser;
		this.whiteLabel = whiteLabel;
		setBackground(Color.gray);
		addMouseListener(new Listener());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawLine(g2d);
		drawBoard(g2d);
	}

	private void drawBoard(Graphics2D g2d) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if (board.board[i][j] == Kind.White) {
					g2d.setColor(Color.white);
					g2d.fillOval(i*50 + 5, j*50 + 5, 40, 40);
				} else {
					if (board.board[i][j] == Kind.Black) {
						g2d.setColor(Color.black);
						g2d.fillOval(i*50 + 5, j*50 + 5, 40, 40);
					}
				}
			}
		}
	}

	private void drawLine(Graphics2D g2d) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++){
			g2d.drawLine(0, i*50, 400, i*50);
			g2d.drawLine(i*50, 0, i*50, 400);
		}
	}
	
	private void showMessage(){
		JOptionPane.showMessageDialog(this, "非法位置，请重新选择");
	}
	
	private void update(){
		blackLabel.setText("black: " + board.getBlackNum());
		whiteLabel.setText("White: " + board.getWhiteNum());
		if (board.getCurrentUser() == 0) {
			currentUser.setText("请黑子下");
		} else {
			currentUser.setText("请白子下");
			
		}
	}
	
	class Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point = e.getPoint();
			int x = point.x / 50;
			int y = point.y / 50;
			if (x >=8 || y >=8) {
				return;
			}
			boolean result = board.move(x, y);
			if (!result) {
				showMessage();
			} else{
				update();
				repaint();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
