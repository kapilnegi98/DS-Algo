package DP;

public class Dungeon {
	 public int calculateMinimumHP(int[][] dungeon) {
	        int n = dungeon.length;
	        int m = dungeon[0].length;
	        int dp[][] = new int[n][m];
	        for(int i = n-1;i >= 0;i--){
	            for(int j = m-1;j >= 0;j--){
	                if(i == n-1 && j == m-1){
	        dp[i][j] = Math.min(dungeon[i][j], 0);
	                }else if(i == n-1){
	    dp[i][j] =  Math.min(dungeon[i][j] + dp[i][j+1], 0);                     
	                }else if(j == m-1){
	    dp[i][j] = Math.min(dungeon[i][j] + dp[i+1][j], 0); 
	                }else{
	dp[i][j] = Math.min(dungeon[i][j] + Math.max(dp[i+1][j], dp[i][j+1]), 0);
	                }
	            }
	        }
	        return Math.abs(dp[0][0]) + 1;
	    }
}
