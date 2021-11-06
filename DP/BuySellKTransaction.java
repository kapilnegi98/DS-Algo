package DP;

public class BuySellKTransaction {
	public static int recursion(int arr[],int idx, int k) {
		
		if(k == 0 || idx == 0) {
			return 0;
		}
		
		int inclMax = 0;
		for(int i = idx-1;i >=0;i--) {
			inclMax = Math.max(inclMax, recursion(arr, i, k-1) + arr[idx] - arr[i]);
		}
		return Math.max(recursion(arr, idx-1,k), inclMax);
		
	}
	public static int tab(int arr[],int k) {	
		int n = arr.length;
		int dp[][] = new int[k+1][n];
		
		for(int i = 1;i < dp.length;i++) {
			for(int j = 1;j < dp[0].length;j++) {
				int incl = Integer.MIN_VALUE;
				for(int l = j-1; l >= 0;l--) {
					//dp[i-1][l] -> profit till lth day,
					//dp[i][l] + arr[i] -> profit till ith day and next trasaction buy will be done
					//today
					incl = Math.max(incl, dp[i-1][l] + arr[j] - arr[l]);
				}
				dp[i][j] = Math.max(dp[i][j-1], incl);
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	public static int tabBetter(int arr[],int k) {	
		//check class rec. for understanding.
		int n = arr.length;
		int dp[][] = new int[k+1][n];
		
		for(int i = 1;i < dp.length;i++) {
////			int max = 0;   //will fail
//			int max = Integer.MIN_VALUE; //will pass
//			for(int j = 1;j < dp[0].length;j++) {
//				max = Math.max(max, dp[i-1][j-1] - arr[j-1]);
//				dp[i][j] = Math.max(dp[i][j-1], max + arr[j]);
//			}
			
			
			//or we can update the max at prev position

			int max = dp[i-1][0] - arr[0]; 
			for(int j = 1;j < dp[0].length;j++) {
				dp[i][j] = Math.max(dp[i][j-1], max + arr[j]);
				max = Math.max(max, dp[i-1][j] - arr[j]);
				
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
