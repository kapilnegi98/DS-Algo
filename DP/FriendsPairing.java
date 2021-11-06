package DP;

import java.util.Scanner;

public class FriendsPairing {
	public static int tab(int n) {
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 2;i <=n;i++) {
			dp[2] = dp[i-1] + (i-1)*(dp[i-2]);
		}
		return dp[dp.length-1];
	}
	public static int recursion(int n) {
		
		if(n <= 2) {
			return 1;
		}
		
		int ans1 = recursion(n-1);
		int ans2  = (n-1) * recursion(n-2);
		
		return ans1 + ans2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		recursion(n);
	}

	

}
