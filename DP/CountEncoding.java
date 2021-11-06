package DP;

public class CountEncoding {
	
	
	//for memoization use hashmap
	//or simpler approach memoization(String s, int idx).. use index. and create arr of str.length size.
	public static int recursion(String s) {
		if(s.charAt(0) == 0) {
			return 0; 
		}
		if(s.length() == 0) {
			return 1;
		}
		
		int ans = recursion(s.substring(1));
		if(s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26) {
			ans += recursion(s.substring(2));
		}
		return ans;
	}
	
	public static int dp(String s) {
		int dp[] = new int[s.length()+1];
	dp[0] = 1;
	for(int i = 1; i < dp.length;i++) {
	/*Cases
	 * 0 0
	 * 0 3
	 * 2 0
	 * 5 0
		
	*/	if(s.charAt(i-1) != 0) {
			dp[i] = dp[i-1];
	}
	if(s.charAt(i-1) != 0 && Integer.parseInt(s.substring(i-2, i)) <= 26) {
		dp[i]+= dp[i-2];
	}
	}
	return dp[dp.length-1];
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
