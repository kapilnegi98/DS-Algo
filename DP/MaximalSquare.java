package DP;

public class MaximalSquare {
	
	 public int maximalSquare(char[][] matrix) {
	     int dp[][] = new int[matrix.length][matrix[0].length];
	     int max = 0;
	     for(int i = 0;i < dp.length;i++) {
	    	 for(int j = 0;j < dp[0].length;j++) {
	    		 if(matrix[i][j] == '1') {
	    			int left = j > 0 ? dp[i][j-1] : 0;
	    			int up = i > 0 ? dp[i-1][j]: 0;
	    			int diag = i > 0 && j > 0 ? dp[i-1][j-1] : 0;
	    			dp[i][j] = Math.min(left, Math.min(up, diag)) + 1;
	    			max = Math.max(max, dp[i][j]);
	    		 }
	    	 }
	     }
	     return max;
	    }
}
