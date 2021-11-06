package DP;

import java.util.Scanner;

public class ArrangeBuildings {
	static int count = 0;
	
	 public static long tab(int n){
	     long dp1[] = new long[n+1];
	     long dp2[] = new long[n+1];
	     dp1[1] = 1; 
	     dp2[1] = 1;
	     for(int i = 2;i<dp1.length;i++){
	         dp1[i] = dp2[i-1];
	         dp2[i] = dp1[i-1]+dp2[i-1];
	     }
	        long ans = dp1[dp1.length-1] + dp2[dp2.length-1];
	        return ans*ans;
	 }
	 
	 public static int memiozation(int n, int lastValue, int dp[][]) {
		 count++;
		 if(n == 0){
		     return 1;
		 }
		 if(dp[lastValue][n] != 0) {
			 return dp[lastValue][n];
		 }
		 int ans = memiozation(n-1, 1, dp);
		 if(lastValue != 0) {
		 ans += memiozation(n-1, 0, dp);
		 }
		 dp[lastValue][n] = ans;
		 return ans;
	 }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	     int n = sc.nextInt();
	     int[][] dp = new int[2][n+1];
	     long ans = memiozation(n, 1, dp);
	     System.out.println(ans * ans);
	     System.out.println(count);
	}

}
