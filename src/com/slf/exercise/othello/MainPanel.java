package com.slf.exercise.othello;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	private Board board;
	private BoardPanel boardPanel;
	private JPanel statusJpanel;
	private JLabel blackLabel;
	private JLabel whiteLabel;
	private JLabel currentUser;
	public MainPanel() {
		// TODO Auto-generated constructor stub
		board = new Board();
		statusJpanel = new JPanel();
		statusJpanel.setPreferredSize(new Dimension(400, 100));
		statusJpanel.setLayout(new GridLayout(1, 3));
		blackLabel = new JLabel("black : 2");
		blackLabel.setAlignmentY(CENTER_ALIGNMENT);
		whiteLabel = new JLabel("white: 2");
		whiteLabel.setAlignmentY(CENTER_ALIGNMENT);
		currentUser = new JLabel("гК╨звсоб");
		currentUser.setAlignmentY(CENTER_ALIGNMENT);
		statusJpanel.add(blackLabel);
		statusJpanel.add(currentUser);
		statusJpanel.add(whiteLabel);
		statusJpanel.setAlignmentX(CENTER_ALIGNMENT);
		boardPanel = new BoardPanel(board, whiteLabel, blackLabel, currentUser);
		add(boardPanel);
		add(statusJpanel);

	}
}
