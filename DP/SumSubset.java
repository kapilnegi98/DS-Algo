package DP;

import java.util.Scanner;

public class SumSubset {
	static int count = 0;
	public static boolean recursion2(int[] arr, int idx, int tar) {
		count++;
		if(tar == 0) {
			return true;
		}
			if(idx == arr.length) { //||target < 0 but cannot be applied if elems are negative.
			    return false;
			}
		boolean  ans1 = recursion2(arr, idx+1, tar);
		if(ans1 == true) {
			return ans1;
		}
		boolean ans2 = recursion2(arr, idx+1, tar-arr[idx]);
		return ans2;
		
	}
	

	public static boolean recursion(int[] arr, int idx, int tar, int sum) {
		if(tar == sum) {
			return true;
		}
			if(idx == arr.length) {
			    return false;
			}
		boolean  ans1 = recursion(arr, idx+1, tar, sum);
		if(ans1 == true) {
			return ans1;
		}
		boolean ans2 = recursion(arr, idx+1, tar, sum + arr[idx]);
		return ans2;
		
	}
	//2 D matrix because 2 parameters are changing
	public static boolean memiozation(int[] arr, int idx, int tar, Boolean dp[][]) {
		
		if(tar == 0) {
			return true;
		}
		if(idx == arr.length || tar < 0) { 
			    return false;
			}
		if(dp[idx][tar] != null) {
			return dp[idx][tar];
		}
		boolean  ans1 = memiozation(arr, idx+1, tar,dp);
		if(ans1 == true) {
			dp[idx][tar] = ans1;
			return ans1;
		}
		boolean ans2 = memiozation(arr, idx+1, tar-arr[idx],dp);
		dp[idx][tar] = ans2;
		return ans2;
		
	}
	
	
	  public static boolean tab(int arr[], int tar) {
			boolean dp[][] = new boolean[arr.length+1][tar+1];
			for(int i = 1;i < dp.length;i++) {
				dp[i][0] = true;
				for(int j = 1;j < dp[0].length;j++) {
					dp[i][j] = dp[i-1][j];
					if((j - arr[i-1]) >= 0) {
						dp[i][j] = dp[i][j] || dp[i-1][j - arr[i-1]];
					}
				}
			}
			return dp[dp.length-1][dp[0].length-1];
		}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				 Scanner sc = new Scanner(System.in);
					int n = sc.nextInt();
					int arr[] = new int[n];
					for(int i = 0;i< n;i++) {
						arr[i] = sc.nextInt();
					}
					int tar = sc.nextInt();
					Boolean dp[][] = new Boolean[n][tar+1];
					recursion2(arr,0,tar);
//					System.out.println(memiozation(arr, 0, tar, dp));
					System.out.println(count);
	}

}
