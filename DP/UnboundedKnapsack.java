package DP;

public class UnboundedKnapsack {
	public static int recursive(int w[], int v[],int idx, int cap) {
		if(cap < 0) {
			return Integer.MIN_VALUE;
		}
		if(cap == 0) {
			return 0;
		}
		int ans1 = v[idx] + recursive(w,v,idx,cap-w[idx]);
		int ans2 = recursive(w, v, idx+1, cap);
		return Math.max(ans1, ans2);
	}
	public static int dp(int w[], int v[],int cap) {
		int dp[] = new int[cap+1];
		dp[0] = 0; //because here we are considering value not price, so if cap = 0, we cannot add any item
		for(int i = 0; i < w.length;i++)
		for(int j = w[i];j < dp.length;j++) {
			dp[j] = Math.max(dp[j], dp[j - w[i]]);
		}
		return dp[dp.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
