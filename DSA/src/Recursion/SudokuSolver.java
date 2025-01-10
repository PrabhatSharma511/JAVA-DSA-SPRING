package Recursion;



public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = {
			    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
			};
		solve(board);
		printBoard(board);
	}

	private static void solve(char[][] board) {
		helper(board,0,0);
	}

	private static boolean helper(char[][] board, int row, int col) {
		
		if(row == board.length) {
			return true;
		}
		
		int nRow = 0;
		int nCol = 0;
		
		if(col == board.length-1) {
			nCol=0;
			nRow=row+1;
		}else {
			nRow=row;
			nCol=col+1;
		}
		
		
		if(board[row][col] != '.') {
			if(helper(board, nRow, nCol)){
				return true;
			}
		}else {
			for(int i=1;i<=9;i++) {
				if(isSafe(board, row, col, i)) {
					board[row][col] = (char)(i+'0');
					if(helper(board, nRow, nCol)) {
						return true;
					}else {
						board[row][col] = '.';
					}
				}
			}
		}
		
		return false;
		
	}

	private static boolean isSafe(char[][] board, int row, int col, int num) {
		
		char c = (char)(num + '0');
		
		//col
		for(int i=0;i<board.length;i++) {
			if(board[i][col] == c) {
				return false;
			}
		}
		
		//row
		for(int j=0;j<board.length;j++) {
			if(board[row][j]==c) {
				return false;
			}
		}
		
		//grid
		int sr = (row/3)*3;
		int sc = (col/3)*3;
		
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(board[i][j]==c) {
					return false;
				}
			}
		}
		
		return true;
	}
	
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
	
}
