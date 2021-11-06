package DP;

import java.util.Scanner;

public class Coin {
	
	public static int recursion(int[] d, int amount, int idx) {
		if(amount ==0) {
			return 1;
		}
		if(amount < 0 || idx == d.length) {
			return 0;
		}
		int f1 = recursion(d,amount, idx+1);
		int f2 = recursion(d, amount - d[idx], idx);
		int ans = f1+f2;
		return ans;
	}
	
	public static int recursion2(int[] arr,int idx, int amt) {
	//TC - > 2^amount	
		if(amt == 0) {
			return 1;
		}
		if(amt < 0 || idx == arr.length) {
			return 0;
		}
		
		return recursion2(arr, idx, amt - arr[idx]) + recursion2(arr, idx+1, amt);
	}
	
	public static int recursionToSolveSomeoneDoubt(int[] arr, int amount, int idx) {
		if(amount < 0) {
			return 0;
		}
		if(amount == 0) {
			return 1;
		}
		int res = 0;
		for(int i = idx;i >= 0;i--) {
			res += recursionToSolveSomeoneDoubt(arr, amount - arr[i], i);
		}
		
		System.out.println(res);
		return res;
	}
	public static int rec(int[] arr, int amount, int id) {
		//someone other wrong code
		if(amount < 0|| id >= arr.length) {
			return 0;
		}
		if(amount == 0 || id == arr.length -1) {
			return 1;
		}
		int start = arr[id];
		int res=0;
		for(int i = start;i < amount;i++) {
			res += rec(arr, amount - start, id+1);
		}
		System.out.println(res);
		return res;
	}
	public static int cc(int[] d, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for(int i = 0;i < d.length;i++) {
			int coin = d[i];
			for(int j = coin;j < dp.length;j++) {
				dp[j] = dp[j] + dp[j - coin];
			}
		}
		return dp[dp.length-1];
	}
	public static int dp2(int[] arr, int amount) {
		int dp[][] = new int[arr.length+1][amount+1];
		for(int i = 1;i < dp.length;i++) {
			dp[i][0] = 1;
			for(int j = 1; j < dp[0].length;j++) {
				dp[i][j] = dp[i-1][j];
				if(j - arr[i-1] >= 0) {
					dp[i][j] += dp[i][j - arr[i-1]];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	 public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int d[] = new int[n];
	        for(int i = 0;i < n;i++){
	            d[i] = sc.nextInt();
	        }
	        int amount = sc.nextInt();
	        System.out.println(recursionToSolveSomeoneDoubt(d, amount,n-1));
	        System.out.println("-------");
	        System.out.println(rec(d, amount,0));

	    }

}
