package DP;

public class PartitionKSubsets {
	  public static long partitionKSubset(int n, int k) {
	     if(n < k) {
	    	 return 0;
	     }
		  if(k == 1) {
	    	  return 1;
	      }
	      if(n == k) {
	    	  return 1;
	      }
	      
		 long ans1 =  partitionKSubset(n-1, k-1);
		 long ans2 =   k * partitionKSubset(n-1, k);
		 return ans1 + ans2;
	    }
	  public static long tab(int n, int k) {
		  
		  
		  long dp[][] = new long[k+1][n+1];
		  for(int i = 1;i < dp.length;i++) {
			  for(int j = 1;j < dp[0].length;j++) {
				  if(i == j) {
					  dp[i][j]= 1;
				  }else if(i > j) {
					  dp[i][j] = 0;
				  }else {
					  dp[i][j] = dp[i-1][j-1] + (i * dp[i][j-1]);  
				  }
			  }
			 
		  }
		  return dp[dp.length-1][dp[0].length-1];
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
