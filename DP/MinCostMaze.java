package DP;

import java.util.Scanner;

public class MinCostMaze {
	
	 public static int recursion(int[][] maze,int n,int m, int cost) {
			if(n == maze.length || m == maze[0].length) {
				return Integer.MAX_VALUE;
			}
				cost += maze[n][m];
			if(n == maze.length-1 && m == maze[0].length-1) {
				return cost;
			}
			
		
			
			return Math.min(recursion(maze, n +1, m, cost), recursion(maze, n, m+1, cost));
			
		}
	 public static int recursion2(int[][] maze,int n,int m) {
			if(n == maze.length || m == maze[0].length) {
				return Integer.MAX_VALUE;
			}
				
			if(n == maze.length-1 && m == maze[0].length-1) {
				return maze[n][m];
			}
			
		
			
			return Math.min(recursion2(maze, n +1, m), recursion2(maze, n, m+1)) + maze[n][m];
			
		}

	 public static int memoization(int[][] maze,int n,int m, int cost, int[][] dp) {
			if(n == maze.length || m == maze[0].length) {
				return Integer.MAX_VALUE;
			}
			if(dp[n][m] != 0) {
				return dp[n][m];
			}
			if(n == maze.length - 1 && m == maze[0].length -1) {
				return maze[n][m];
			}
			
			int ans =  Math.min(recursion(maze, n +1, m, cost), recursion(maze, n, m+1, cost));
			ans += maze[n][m];
			dp[n][m] = ans;
			return ans;
		}
	 public static int tab(int[][] maze,int n, int m) {
		 int dp[][] = new int[n][m];
		 dp[n-1][m-1] = maze[n-1][m-1];
		 for(int i = n-1; i >= 0; i--) {
			 for(int j = m-1;j >= 0; j--) {
			     if(i == n-1 && j == m-1){
			        continue;
			     }
				 int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
				 if(i + 1 < n) {
					 left = dp[i+1][j];
				 }
				 if(j+1 < m) {
					 right = dp[i][j+1];
				 }
				 dp[i][j] = Math.min(left, right)+ maze[i][j]; 
			 }
		 }
		 return dp[0][0];
	 }
	 public static int tab2(int[][] maze) {
		 int dp[][] = new int[maze.length][maze[0].length];
		 
		 for(int i = maze.length-1; i >= 0; i--) {
			 for(int j = maze[0].length-1;j >= 0; j--) {
			     if(i == maze.length-1 && j == maze[0].length-1){
			        dp[i][j] = maze[i][j];
			     }else if(i == maze.length-1) {
			    	 dp[i][j] = dp[i][j+1] + maze[i][j];
			     }else if(j == maze[0].length - 1) {
			    	 dp[i][j] = dp[i+1][j] + maze[i][j];
			     }else {
			    	 dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+ maze[i][j]; 
			     }
			 }
		 }
		 return dp[0][0];
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			 int arr[][] = new int[n][m];
			 for(int i = 0;i < n;i++){
			     for(int j = 0;j<m;j++){
			         arr[i][j] = sc.nextInt();
			     }
			 }
			 System.out.println(recursion(arr,0,0,0));
	}

}
