package DP;

public class BuySellInfiniteTransaction {
	 public static int iter(int[] arr){
		 int profit = 0;
		 for(int i = 0;i < arr.length-1;i++) {
			 if(arr[i+1] > arr[i])
				 profit += arr[i+1] - arr[i];
		 }
		 return profit;
	 }
	 public static int dp(int[] arr){
		//at each ith index buystate will be less than sellstate.
		 int buyState[] = new int[arr.length];
		 int sellState[] = new int[arr.length];
		 buyState[0] = -arr[0];
		 sellState[0] = 0;
		 for(int i = 1;i < arr.length;i++) {
			buyState[i] = Math.max(buyState[i-1], sellState[i-1] - arr[i]);
			sellState[i] = Math.max(sellState[i-1], buyState[i-1] + arr[i]);
		 }
		 return sellState[sellState.length-1];
	 }
	
	public static void main(String[] args) {
		

	}

}
