package DP;

public class DecodeWays {
	  public int numDecodings(String s) {
	        if(s.charAt(0) == '0') {
	        	return 0;
	        }
			int dp[] = new int[s.length()];
			dp[0] = 1; 
			for(int i=1;i < dp.length;i++) {
				if(s.charAt(i) != '0') {
					dp[i] = dp[i-1];
				}
				if(s.charAt(i-1) != '0' && Integer.parseInt(s.substring(i-1, i+1)) <= 26) {
	                 
					dp[i] += (i == 1) ? 1 : dp[i-2];
	               
				}
				
			}
			return dp[dp.length - 1];
	    }
}
