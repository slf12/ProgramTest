package com.slf.exercise.queen;

public class Queens {
	private boolean[][] queen; //true 表示有皇后， false表示没有
	
	private int tempRow;
	private int tempCol;
	
	public int conflictRow;
	public int confictCol;
	
	public Queens() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public boolean[][] getQueen() {
		return queen;
	}

	public void setQueen(boolean[][] queen) {
		this.queen = queen;
	}

	public int getTempRow() {
		return tempRow;
	}

	public void setTempRow(int tempRow) {
		this.tempRow = tempRow;
	}

	public int getTempCol() {
		return tempCol;
	}

	public void setTempCol(int tempCol) {
		this.tempCol = tempCol;
	}

	public void init() {
		queen = new boolean[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				queen[i][j] = false;
			}
		}
		tempCol = -1;
		tempRow = -1;
		confictCol = -1;
		conflictRow = -1;
	}
	
	public boolean check(int row, int col){
		return checkItem(row, col, 0, 1) && checkItem(row, col, 1, 0) && checkItem(row, col, -1, 0) &&
				checkItem(row, col, 0, -1) && checkItem(row, col, 1, 1) && checkItem(row, col, 1, -1) && checkItem(row, col, -1, 1)
				&& checkItem(row, col, -1, -1);
	}
	
	private boolean checkItem(int row, int col, int x_add, int y_add){
		for(int i = row + y_add, j = col + x_add; i >=0 && i < 8 && j >= 0 && j < 8; i = i+y_add, j = j + x_add){
			if (queen[i][j]) {
				conflictRow = i;
				confictCol = j;
				return false;
			}
		}
		return true;
	}
	
	public boolean checkWin(){
		int num = 0; 
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if (queen[i][j]) {
					num++;
				}
			}
		}
		if (num == 8) {
			return true;
		}
		return false;
	}
}
