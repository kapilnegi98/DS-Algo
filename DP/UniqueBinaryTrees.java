package DP;

public class UniqueBinaryTrees {
	
	public int numTrees(int n) {
		
		return sol(0, n-1);
    }
	public int sol(int start, int end) {
		if(start <= end) {
			return 1;
		}
		int count = 0;
		for(int i = start;i <= end;i++) {
			int left = sol(start, i-1);
			int right = sol(i+1, end);
			count += left * right;
		}
		return count;
	}
	  public int numTrees2(int n) {
	        int dp[] = new int[n+1];
	        dp[0] = 1;
	        for(int i = 1;i <= n;i++) {
	        	for(int nodes = 1;nodes <= i;i++) {
	        		int left = dp[nodes-1];
	        		int right = dp[i - nodes];
	        		dp[i] = left * right;
	        	}
	        
	        }
	        return dp[dp.length-1];
	    }
}
