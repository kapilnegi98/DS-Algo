package DP;

public class Tiling2xn {
	public static int tab(int n) {
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i < n;i++) {
			dp[i] = dp[i-1] + dp[i-2]; 
		}
		return dp[n];
	}
	
	public static int recursion(int n) {
		if(n < 0) {
			return 0;
		}
		if(n == 0){
			return 1;
		}
		//fibonacci
		return recursion(n-1) + recursion(n-2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
