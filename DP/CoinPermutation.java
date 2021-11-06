package DP;

public class CoinPermutation {
	
	public static int dp(int[] arr, int amt) {
		//campare it with recurr sol. and each pos. i am calling all numbers.
		int dp[] = new int[amt+1];
		//there is one way to pay 0 coin that is . and append other coin to it.
		//check sumeet video.
		dp[0] = 1;
		for(int i = 1;i < dp.length;i++) {
			for(int j = 0; j < arr.length;j++) {
				if(i - arr[j] >= 0) {
				dp[i] += dp[i - arr[j]];
				}
			}
		}
		return dp[dp.length-1];
	}
	
	public static int recursion(int[] arr, int amt) {
		if(amt < 0) {
			return 0;
		}
		if(amt == 0) {
			return 1;
		}
		int ways = 0;
		for(int i = 0;i < arr.length;i++) {
			ways += recursion(arr, amt - arr[i]);
		}
		return ways;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
