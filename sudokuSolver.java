package sudoku;

import java.util.Scanner;

public class sudokuSolver {

	public static boolean sudokusolver(int board[][]) {
		int row = -1;
		int col = -1;
		boolean flag = false;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == 0) {
					row = i;
					col = j;
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}	
		}
		if(row == -1) {
			return true;
		}
		for(int num = 1; num <= 9; num++) {
			if(isPossible(board, row, col, num)) {
				board[row][col] = num;
				if(sudokusolver(board)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		return false;
	}
	
	public static boolean isPossible(int[][] board, int row, int col, int num) {
		if(presentInRow(board, row, num)) {
			return false;
		}
		if(presentInCol(board, col, num)) {
			return false;
		}
		if(presentInBox(board, row - row % 3, col - col % 3, num)) {
			return false;
		}
		return true;
	}
	
	private static boolean presentInBox(int[][] board, int row,int col, int num) {
		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++){
				if(board[i][j] == num) {
				   return true;
			    }
		    }
	    }	
		return false;
	}
	
	private static boolean presentInCol(int[][] board, int col,int num) {
		for(int j = 0; j < 9; j++){
			if(board[j][col] == num) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean presentInRow(int[][] board, int row,int num) {
		for(int j = 0; j < 9; j++){
			if(board[row][j] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		 
	
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		
		int board[][] = new int[m][n];
		for(int i = 0;i < m; i++){
			for(int j = 0; j < n; j++){
				board[i][j] = s.nextInt();
			}
		}
		boolean ans = sudokusolver(board);
		System.out.println(ans);
		for( int i = 0; i < m;i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		// TODO Auto-generated method stub

	}

}
