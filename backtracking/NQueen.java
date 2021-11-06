package backtracking;

public class NQueen {
	
	static void func(int[][] board, int row) {
		int n = board.length;
		
		if(row == n) {
			for(int i=0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					System.out.print(board[i][j]+ " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		for(int j=0;j<n;j++) {
			if(isPossible(board, row, j)) {
				board[row][j] = 1;
				func(board, row+1);
				board[row][j] = 0;
			}
		}
		
				
			
	}
	
	private static boolean isPossible(int[][] board, int r, int c) {
		// TODO Auto-generated method stub
		for(int i = r-1, j =c-1;i >= 0 && j>=0;i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		for(int i = r-1, j =c+1;i >= 0 && j<board.length;i--,j++) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		for(int i = r-1;i >= 0;i--) {
			if(board[i][c] == 1) {
				return false;
			}
		}
		return true;
	}

	
	public static void main(String args[]) {
		int[][] board = new int[8][8];
		
		func(board, 0);
	}
}
