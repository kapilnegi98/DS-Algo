package DP;

//we can't do this-> sell -buy - fee is positive we add this. but consider this
// 2 7 6 11 it is better to do one tracsanc.


public class BuySellFeeInfiniteTransaction {
	 public static int dp(int[] arr, int k){
			
		 int buyState[] = new int[arr.length];
		 int sellState[] = new int[arr.length];
		 buyState[0] = -arr[0];
		 sellState[0] = 0;
		 for(int i = 1;i < arr.length;i++) {
			buyState[i] = Math.max(buyState[i-1], sellState[i-1] - arr[i]);
			sellState[i] = Math.max(sellState[i-1], buyState[i-1] + arr[i] - k);
		 }
		 return sellState[sellState.length-1];
	 }
	
	
	public static void main(String[] args) {
		

	}

}
