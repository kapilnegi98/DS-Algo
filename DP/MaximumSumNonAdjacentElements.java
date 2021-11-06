package DP;

public class MaximumSumNonAdjacentElements {
	
	public static int recursion(int arr[], int idx) {
		if(idx >= arr.length) {
			return 0;
		}
		int ans1 = recursion(arr, idx + 1);
		
		int ans2 = arr[idx] + recursion(arr, idx + 2);
		return Math.max(ans1, ans2);
	}
	public static int mem(int arr[], int idx,int[] dp) {
		if(idx >= arr.length) {
			return 0;
		}
		if(dp[idx] != 0){
		    return dp[idx];
		}
		int ans1 = mem(arr, idx + 1, dp);
		
		int ans2 = arr[idx] + mem(arr, idx + 2, dp);
		dp[idx] = Math.max(ans1, ans2);
		return dp[idx];
	}
	public static int tab(int arr[]) {
		int dp[] = new int[arr.length + 1];
		dp[1] = Math.max(0, arr[0]); // if is negative.
 		for(int i = 2;i < dp.length;i++) {
			dp[i] = Math.max(dp[i-1], arr[i-1] + dp[i-2]);
		}
		return dp[dp.length-1];
	}

	public static int tab2(int arr[]) {
		
		//can be done without array, using only variables.
		int incl[] = new int[arr.length + 1];
		int excl[] = new int[arr.length + 1];
		incl[0] = excl[0] = 0;
		incl[1] = arr[0];
		excl[1] = 0;
		for(int i = 2;i < incl.length;i++) {
			excl[i] = Math.max(incl[i-1], excl[i-1];
			incl[i] = excl[i-1] + arr[i-1];
		}
		return Math.max(excl[excl.length - 1], incl[incl.length - 1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
