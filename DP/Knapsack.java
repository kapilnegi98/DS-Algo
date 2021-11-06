package DP;

import java.util.Scanner;

public class Knapsack {
	public static int count = 0;
	public static int recursive(int[] prices, int[] w, int idx, int cap) {
		count++;
//		if(cap == 0) {  //will fail if w = 0 and cap is something, we will miss this//but w cannot be neg so it will work
		
//			return 0;
//		}
		if(cap < 0) {
			return Integer.MIN_VALUE;
		}
		if(idx == prices.length) {
			return 0;
		}
		int f2 = prices[idx] + recursive(prices,w,idx+1, cap - w[idx]);
	
		int f1 = recursive(prices,w,idx+1,cap);
		
		int ans = Math.max(f1, f2);
//		System.out.println(ans);
		return ans;
	}
	public static int memiozation(int prices[],int []w,int idx, int dp[][], int cap) {
		count++;
		if(cap < 0) {
			return Integer.MIN_VALUE;
		}
		if(idx == prices.length) {
			return 0;
		}
		
		if(dp[idx][cap] != 0) {
			return dp[idx][cap];
		}
		int f2 = prices[idx] + memiozation(prices,w,idx+1,dp, cap - w[idx]);
		
		int f1 = memiozation(prices,w,idx+1,dp,cap);
		
		
		int ans = Math.max(f1, f2);
//		System.out.println(ans);
		dp[idx][cap] = ans;
		return ans;
		
	
	}
	public static int tab(int[] v, int[] w, int cap) {
		int dp[][] = new int[v.length+1][cap+1];
		for(int i = 1; i < dp.length;i++) {
			for(int j = 1;j < dp[0].length;j++) {
			dp[i][j] = dp[i-1][j];
			if(j - w[i-1] >= 0) {
				dp[i][j] = Math.max(dp[i][j], v[i-1] + dp[i-1][j - w[i-1]]);
			}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int val[] = new int[n];
			int w[] = new int[n];
			for(int i = 0;i< n;i++) {
				val[i] = sc.nextInt();
			}
			for(int i = 0;i< n;i++) {
				w[i] = sc.nextInt();
			}
			int c = sc.nextInt();
//			tab(val,w,c);
	System.out.println(recursive(val,w,0,c));
			int dp[][] = new int[w.length][c+1];
//			System.out.println(memiozation(val,w,0,dp,c));
			System.out.println(count);
	}

}
