package SearchingAndSorting;

//other approach sort array and do arr[i] * i, because max element * max index is maimum.
//but nlogn.
public class MaxSumConfiguration {
	 public static int maximise(int[]arr) {
	        //write your code here
	        int sum = 0;
	        for(int i = 0;i < arr.length;i++){
	            sum+= arr[i];
	        }
	        int firstSum = 0;
	        for(int i = 0;i < arr.length;i++){
	            firstSum+= (arr[i]*i);
	        }
	        int maxSum = firstSum;
	        for(int i = arr.length - 1;i >= 1;i--){
	            firstSum = firstSum + sum - (arr.length * arr[i]);
	            maxSum = Math.max(maxSum, firstSum);
	        }
	        return maxSum;
	    }
}
