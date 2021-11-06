package DP;

public class BuySellTwoTransaction {
	
	public static int iteration(int arr[]) {	
		
		//at ith index... considering left portion and right portion what max. can we make
		//till this point.
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int min = arr[0];
		for(int i = 1;i < n;i++) {
			min = Math.min(min, arr[i]);
			left[i] = Math.max(left[i-1], arr[i] - min);
		}
		int max = arr[n-1];
		for(int i = n-2;i >= 0;i--) {
			max = Math.max(max, arr[i]);
			right[i] = Math.max(right[i+1], max - arr[i]);
		}
		int profit = 0;
		for(int i = 0;i < n;i++) {
			profit = Math.max(profit, left[i] + right[i]);


//			profit = Math.max(profit, left[i] + right[i+1]);
			//this will fail for this 2 0 7 and we run loop till i < n-1
		}
		
		return profit;
		 	
	}           
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
