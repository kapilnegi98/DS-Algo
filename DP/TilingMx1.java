package DP;

public class TilingMx1 {
	public static int tab(int m, int n) {
		int dp[] = new int[n+1];
//		dp[0] = 1;
//		dp[1] = 1;
//		for(int i = 2;i <= n;i++) {
//			dp[i] = dp[i-1];
//			if(i >= m) {
//				dp[i] += dp[i-m];
//			}
//			
//		}
		dp[1] = 1;
		for(int i = 1;i <= n;i++) {
			if(i < m) {
				dp[i] = 1;
			}else if(i == m) {
				dp[i] = 2;
			}else {
				dp[i] = dp[i-1]+ dp[i-m];
			}
			
		}
		return dp[n];
	}
	
	public static int recursion(int m ,int n) {
		if(n < 0) {
			return 0;
		}
		if(n == 0){
			return 1;
		}
		//fibonacci
		return recursion(m, n-1) + recursion(m, n-m);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
