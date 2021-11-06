package DP;

public class BuySellOneTransaction {
	
	public static int iteration(int arr[]) {
		
		/*		
			1. why we need lefMin.. we can only check rightMax - arr[i];
			2.brute force -> from left to right check the maximam element of ith element. two loops
			3. we can do it using only 1 for loop.. traverse from right. 	
		*/		
		int n = arr.length;
		int rightMax[] = new int[n];
		rightMax[n - 1] = arr[n - 1];
		for(int i = rightMax.length - 2;i >= 0;i++) {
			rightMax[i] = Math.max(rightMax[i+1], arr[i]);
		}
		int leftMin = arr[0];
		int profit = 0;
		for(int i = 1;i < arr.length;i++) {
			leftMin = Math.min(leftMin, arr[i]);
			if(rightMax[i] - leftMin > profit) {
				profit = rightMax[i] - leftMin;
			}
		}
		return profit;
	}
	 public static int iteration4(int[] arr){
	        int low = arr[0], profit = 0;
	        for(int i = 1;i < arr.length;i++){
	            low = Math.min(low,arr[i]);
	            profit = Math.max(profit, arr[i] - low);
	            
	        }
	        return profit;
	    }
	
public static int iteration2(int arr[]) {
	
	//we can go from left to right also... maintain the leftMin.we we want to selll today we nee
	//min value in the left of this index.
	/*
	1. right to left--> if i buy today when i can sell;
	2. left to right--> if i sell today when i can buy.
	
	*/
		int profit = 0;
		int rightMax = arr[arr.length-1];
		for(int i = arr.length-2; i >= 0;i--) {
			rightMax = Math.max(rightMax, arr[i]);
			profit = Math.max(profit, rightMax - arr[i]);
			
		}
		
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
