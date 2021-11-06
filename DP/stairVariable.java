package DP;

import java.util.Scanner;

public class stairVariable {
	
	//recursive(int[] arr, int idx) ---no need to use n
	public static int recursive(int n, int[] arr) {
		if(n < 0) {
			return 0;
		}
		if( n == 0) {
			return 1;
		}
		int jumps = arr[arr.length - n];
		int count = 0;
		System.out.println(n);
		for(int i = 1;i <= jumps;i++) {
			count += recursive(n - i, arr);
			System.out.println("count" + count);
		}
		return count;
		
		
	}
	public static int memoization(int n, int[] arr, int[] dp) {
		
		if(n < 0) {
			return 0;
		}
		if( n == 0) {
			return 1;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		int jumps = arr[arr.length - n];
		int count = 0;
		
		for(int i = 1;i <= jumps;i++) {
			count += recursive(n - i, arr);
			System.out.println("count" + count);
		}
		dp[n] = count;
		return count;
		
	}
	public static int tab(int n, int[] arr) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i = 1;i <= n;i++) {
			int jumps = arr[arr.length - i];
			for(int j = 1; j <= jumps; j++) {
				if(i - j >= 0) {
				dp[i] += dp[i - j];
				}
			}
		}
		return dp[n];
	}
	public static int tab2(int n, int[] arr) {
		int[] dp = new int[n+1];
			dp[n] = 1;
			for(int i = n-1;i >= 0;i--) {
				int jumps = arr[i];
				for(int j = 1; j <= jumps; j++) {
					if(i + j <= n) {
					dp[i] += dp[i + j];
					}
				}
			}
			return dp[0];
			
			
		}
	public static int tab3(int n, int[] arr) {
		//n^2
		int[] dp = new int[n+1];
			dp[0] = 1;
			for(int i = 1;i <= n;i++) {
				for(int j = i-1; j >= 0; j--) {
					if(i - j <= arr[j]) {
						dp[i] += dp[j];	
						System.out.println(dp[i]);
					}
					System.out.println(dp[i]);
					
				}
			}
			return dp[n];
			
			
		}



	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 int arr[] = new int[n];
	        for(int i = 0;i < n;i++){
	            arr[i] = sc.nextInt();
	        }
		System.out.println(tab3(n, arr));
	}
}
