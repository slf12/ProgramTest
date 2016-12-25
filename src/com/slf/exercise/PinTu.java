package com.slf.exercise;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PinTu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PinTu() {
		// TODO Auto-generated constructor stub
		setTitle("拼图");
		setPreferredSize(new Dimension(400, 400));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MainPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PinTu();
			}
		});
	}

}

class Chess{
	int[][] chess_state = new int[4][4];
	public Chess() {
		// TODO Auto-generated constructor stub
		Random random = new Random();
		HashMap<Integer, Integer>  map = new HashMap<>();
		for (int i = 0; i < chess_state.length; i++) {
			int temp;
			for (int j = 0; j < chess_state[i].length; j++) {
				if (i == chess_state.length - 1 && j == chess_state[i].length - 1) {
					break;
				}
				while(true){
					temp = random.nextInt(15) + 1;
					if (map.get(temp) == null) {
						map.put(temp, 1);
						break;
					}
				}
			chess_state[i][j] = temp;				
			}
		}
		chess_state[3][3] = 0;
	}
	
	public int click(int index_i, int index_j) {
		int i_0 = 0, j_0 = 0;
		if (index_i+1 < 4 && chess_state[index_i+1][index_j] == 0)  {
			i_0 = index_i + 1;
			j_0 = index_j;
		} else if (index_i - 1 >= 0 && chess_state[index_i - 1][index_j] == 0) {
			i_0 = index_i - 1;
			j_0 = index_j;
		} else if (index_j + 1 < 4 && chess_state[index_i][index_j+1] == 0) {
			i_0 = index_i;
			j_0 = index_j + 1;
		} else if (index_j - 1 >= 0 && chess_state[index_i][index_j - 1] == 0) {
			i_0 = index_i;
			j_0 = index_j - 1;
		} else {
			return -1;
		}
		chess_state[i_0][j_0] = chess_state[index_i][index_j];
		chess_state[index_i][index_j] = 0;
		if(checkWin()){
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public boolean checkWin() {
		int k = 1;
		for (int i = 0; i < chess_state.length; i++) {
			for (int j = 0; j < chess_state[i].length; j++) {
				if (i == chess_state.length - 1 && j == chess_state[i].length - 1) {
					break;
				}
				if (chess_state[i][j] == k) {
					k++;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Chess chess;
	public MainPanel() {
		// TODO Auto-generated constructor stub
		//super();
		this.chess = new Chess();
		setPreferredSize(new Dimension(400, 500));
		addMouseListener(new Click());
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		for(int i = 0;  i < 5; i++){
			graphics2d.drawLine(100, 100 + i * 50, 300, 100 + i* 50);
			graphics2d.drawLine(100 + i * 50, 100, 100 + i * 50, 300);
		}
		
		for (int i = 0; i < chess.chess_state.length; i++) {
			for (int j = 0; j < chess.chess_state[i].length; j++) {
				if (chess.chess_state[i][j] == 0) {
					continue;
				}
				graphics2d.drawString(chess.chess_state[i][j] + "", 100 + i * 50 + 20, 100 + j * 50 + 20);
			}
		}
	}
	
	public void showMessage(int n) {
		if (n == -1) {
			JOptionPane.showMessageDialog(this, "位置不合法");
		} else {
			JOptionPane.showMessageDialog(this,	 "赢了");
		}
	}
	
	class Click implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			if (x <= 100 || y <= 100 || x >= 300 || y >= 300) {
				return;
			}
			int i = (x - 100) / 50;
			int j = (y - 100) / 50;
			int state = chess.click(i, j);
			if (state == 0) {
				repaint();
			} else {
				showMessage(state);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		
		} 
		
	}
	
}
