package DP;

public class CountBinary {
	//third method of dp same as fibonaaci.
	
	public static int tab2(int n) {
		//without array
		int dp1 = 1;
		int dp2 = 1;
		
		for(int i = 2;i < n;i++) {
			int temp = dp2;
			dp2 = dp2 + dp1;
			dp1 = temp;
		}
		return dp1 + dp2;
	}
	public static int tab(int n) {
		int dp1[] = new int[n+1];
		int dp2[] = new int[n+1];
		dp1[1] = 1;
		dp2[1] = 1;
		for(int i = 2;i <= n;i++) {
			dp1[i] = dp2[i-1];
			dp2[i] = dp2[i-1] + dp1[i-1];
		}
		return dp1[n] + dp2[n];
	}
	public static int recursion(int n, int prev) {
		if(n == 0) {
			return 1;
		}
		int ans = recursion(n-1, 1);
		if(prev != 0) {
		ans += recursion(n-1, 0);
		}
	
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
