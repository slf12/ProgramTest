package com.slf.exercise.othello;

public class Board {
	public Kind[][] board = new Kind[8][8];
	private int blackNum;
	private int whiteNum;
	private int currentUser; //0 表示黑子，1表示白子
	
	public int getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(int currentUser) {
		this.currentUser = currentUser;
	}

	public Board() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j++){
				board[i][j] = Kind.Nil;
			}
		}
		board[3][3] = Kind.White;
		board[4][4] = Kind.White;
		board[3][4] = Kind.Black;
		board[4][3] = Kind.Black;
		blackNum = 2;
		whiteNum = 2;
		currentUser = 0;
	}
	
	/**
	 * 用户下在i,j位置上
	 * @param user
	 * @param row
	 * @param col
	 */
	public boolean move( int row, int col) {
		return checkBoard( row, col);
	}
	
	private boolean checkBoard(int row, int col) {
		// TODO Auto-generated method stub
		int num = 0;
		num += check(row, col, 1, 0);
		num += check(row, col, 0, 1);
		num += check(row, col, -1, 0);
		num += check(row, col, 0, -1);
		num += check(row, col, 1, -1);
		num += check(row, col, -1, 1);
		num += check(row, col, -1, -1);
		num += check(row, col, 1, 1);
		if (num == 0) {
			return false;	
		} else {
			if (currentUser == 0) {
				blackNum ++;
				board[row][col] = Kind.Black;
			} else {
				whiteNum ++;
				board[row][col] = Kind.White;

			}
			currentUser = 1 - currentUser;
			return true;
		}
		
	}
	
	private int check(int row, int col, int x_add, int y_add){
		Kind same = Kind.Nil;
		if (currentUser == 0) {
			same = Kind.Black;
		} else {
			same = Kind.White;
		}
		int opponint = 0;
		int last_x = 0, last_y = 0;
		for(int i = row + x_add, j = col + y_add; i < 8 && i >=0 && j < 8 && j >=0; i = i+x_add, j = j+y_add){
			if (board[i][j] == Kind.Nil) {
				break;
			}
			if (board[i][j] == same && opponint > 0) {
				last_x = i;
				last_y = j;
			} else {
				opponint ++;
			}
		}
		
		if (opponint == 0 || last_x == 0) {
			return 0;
		}
		
		
		for(int i = row + x_add, j = col + y_add; i < 8 && i >=0 && j < 8 && j >=0; i = i+x_add, j = j+y_add){
			if (board[i][j] == Kind.Nil) {
				break;
			}
			if (board[i][j] != same){
				board[i][j] = same;
				if (currentUser == 0) {
					blackNum ++;
					whiteNum --;
				} else{
					whiteNum ++;
					blackNum --;
				}
			} else {
				break;
			}
		}
		
		
		
		return opponint;
	}

	public int getBlackNum() {
		return blackNum;
	}

	public void setBlackNum(int blackNum) {
		this.blackNum = blackNum;
	}

	public int getWhiteNum() {
		return whiteNum;
	}

	public void setWhiteNum(int whiteNum) {
		this.whiteNum = whiteNum;
	}
}
enum Kind{
	Nil, Black, White
}