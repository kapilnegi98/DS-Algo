package DP;

import java.util.Scanner;

public class Goldmine {
	
	public static int tab2(int arr[][]) {
		int dp[][] = new int[arr.length][arr[0].length];
		for(int j = arr[0].length-1; j>=0;j--) {
			for(int i = 0; i < arr.length;i++) {
				if(j==arr[0].length-1) {
					dp[i][j] = arr[i][j];
				}else if(i == 0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
				}else if(i == arr.length-1) {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);

				}else {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],Math.max(dp[i+1][j+1], dp[i-1][j+1]));

				}
			}
		}
		int max = 0;
		for(int i = 0;i<arr.length;i++) {
			max = Math.max(max, dp[i][0]);
		}
		return max;
	}
	
	public static int tab(int arr[][]) {
		int dp[][] = new int[arr.length][arr[0].length];
		for(int j = arr[0].length-1;j >= 0;j--) {
			
			for(int i = 0;i > arr.length;i++) {
				if(j == arr[0].length) {
					dp[i][j] = arr[i][j];
				}else {
					int right = 0, rightUp = 0, rightDown = 0; 
					 right = arr[i][j+1];
					if(i > 0) {
					 rightUp = arr[i-1][j+1];
					}
					if(i < arr.length-1) {
						rightDown = arr[i+1][j+1];
					}
					dp[i][j] = Math.max(Math.max(right, rightUp), rightDown)+arr[i][j];
				}
				
			}
			
		}
		int max = 0;
		for(int i = 0;i<arr.length;i++) {
			max = Math.max(max, dp[i][0]);
		}
		return max;
		
	}
	
	//for memoization -> TC -> O(n*m)
	public static int recursion(int arr[][], int r, int c) {
		//TC -> O((3^nCOl) * nRow)
		if(r < 0 || c >= arr.length) {
			return Integer.MIN_VALUE;
		}
		if(c == arr[0].length-1) {
			return arr[r][c];
		}
		return Math.max(Math.max(recursion(arr, r-1, c+1),recursion(arr, r, c+1)), 
				recursion(arr, r+1, c+1)) + arr[r][c];
		
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
			 int max = 0;
			 for(int i = 0;i < arr.length;i++) {
				max = Math.max(recursion(arr, i,0), max);
			 }
			 System.out.println(max);

	}

}
