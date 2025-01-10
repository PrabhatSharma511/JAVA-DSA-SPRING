package Recursion;

import java.util.ArrayList;
import java.util.List;

public class BackTracking2 {
	
	private static boolean isSafe(int row, int col, char[][] board) {
		
		//horizontal
		for(int j=0;j<board[0].length;j++) {
			if(board[row][j]=='Q') {
				return false;
			}
		}
		
		//vertical
		for(int i=0;i<board.length;i++) {
			if(board[i][col]=='Q') {
				return false;
			}
		}
		
		//upper left
		int r =row;
		for(int c=col;c>=0 && r>=0;c--,r--) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		
		//upper right
		for(int c=col;c<board[0].length && r>=0;r-- ,c++) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		
		//lower left
		r=row;
		for(int c=col;c>=0 && r<board.length;r++,c--) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		
		//lower right
		for(int c=col;r<board.length && c<board[0].length;r++,c++) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void helper(char[][] board, List<List<String>> allBoards, int col) {
		if(col==board.length) {
			saveBoard(board, allBoards);
			return;
		}
		
		//only one Q in one column
		for(int row=0;row<board.length;row++) {
			System.out.println("outside- "+"row: "+row+" col: "+col);
			if(isSafe(row,col,board)) {
				System.out.println("inside- "+"row: "+row+" col: "+col);
				board[row][col]='Q';
				helper(board, allBoards, col+1);
				board[row][col]='.';
			}
		}
	}

	

	private static void saveBoard(char[][] board, List<List<String>> allBoards) {
		
		List<String> newBoard = new ArrayList<>();
		
		for(int i =0;i<board.length;i++) {
			String row = "";
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='Q') {
					row+='Q';
				}else {
					row+='.';
				}
				
			}
			newBoard.add(row);
		}
		
		allBoards.add(newBoard);
		
		
		
		
	}

	public static List<List<String>> solveNqueens(int n){
		List<List<String>> allBoards = new ArrayList<>();
		char[][] board = new char[n][n];
		
		helper(board, allBoards, 0);
		return allBoards;
		
	}
	
	public static void main(String[] args) {
		System.out.println(solveNqueens(4));
		
	}
	
}
