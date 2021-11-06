package DP;

import java.util.Scanner;

public class Stair {
	public static int recursive(int n) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		
		return recursive(n-1) + recursive(n-2) + recursive(n-3);
		
	}
	public static int memoization(int n, int[] dp) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		int step1 = memoization(n-1, dp);
		
		int step2 = memoization(n-2, dp); 
				
		int step3 = memoization(n-3, dp);
		
		return step1 + step2 + step3;
		
	}
	public static int tab(int n) {
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i = 0;i <= n;i++) {
			int ans = dp[i-1];
			if(i - 2>= 0) {
				ans += dp[i-2]; 
			}
			if(i - 3>= 0) {
				ans += dp[i-3]; 
			}
		}
		return dp[n];
	}

	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(recursive(n));
	}
}
