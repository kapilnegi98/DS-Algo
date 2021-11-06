package DP;

import java.util.Scanner;

public class stairsMinimum {
	static int count = 0;
	
	public static int recursive(int n, int arr[], int idx) {
		count++;
		int min = Integer.MAX_VALUE-1;
		if(idx > arr.length) {
			return min;
		}
		if(idx == arr.length) {
			return 0;
		}
		int jumps = arr[idx];
		
		
		for(int i = 1; i <= jumps; i++) {
			int paths = recursive(n-i, arr, idx+i);
			min = Math.min(paths, min);
		}
		return min + 1; 
	}
	public static int memoization(int n, int arr[], int idx, int[] dp) {
		count++;
		int min = Integer.MAX_VALUE-1;
		if(idx > arr.length) {
			return min;
		}
		if(idx == arr.length) {
			return 0;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		int jumps = arr[idx];
		
		
		for(int i = 1; i <= jumps; i++) {
			int paths = memoization(n-i, arr, idx+i,dp);
			min = Math.min(paths, min);
		}
		dp[n] = min+1;
		return dp[n]; 
	}
	public static int tab(int arr[]) {
		//check recc tree at nth pos we are returning 0 not 1 so here last pos will be 0
		int dp[] = new int[arr.length];
		for(int i = dp.length-2; i >= 0; i--) {
			int min = Integer.MAX_VALUE-1;
			for(int j = 1;i <= arr[i];j++) {
				if(i + j < dp.length) {
				min = Math.min(dp[i+j], min);
				}
				
			}
			dp[i] = min+1;
		}
		return dp[0];
	}
	
public static int greedy(int[] arr) {
	
		//O(n)
		int i = 0;
		int steps = 0;
		while(i <= arr.length - 1) {
		    if(arr[i] == 0){ // 1, 2, 0, 0
		        return Integer.MAX_VALUE;
		    }
			steps++;
			int jump = arr[i];
			int maxIndex = -1, maxValue = -1;
			for(int j = i+1;j <= i+jump; j++) {
			    if(j == arr.length - 1){
			        return steps;
			    }
				if(j + arr[j] > maxValue) {
					maxIndex = j;
					maxValue = j+arr[j];
				}
			}
			i = maxIndex;
		}
		return steps;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 int arr[] = new int[n];
	        for(int i = 0;i < n;i++){
	            arr[i] = sc.nextInt();
	        }
	        int dp[] = new int[n+1];
		System.out.println(recursive(n, arr,0));
		System.out.println(count);

	}

}
