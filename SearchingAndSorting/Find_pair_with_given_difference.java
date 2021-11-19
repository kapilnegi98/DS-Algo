package SearchingAndSorting;

import java.util.Arrays;

public class Find_pair_with_given_difference {
//In finding two elements with sum equals to target, we can use hashset method but in this we can't
	//but we can use hash after sorting
	 public static void findPair(int[]arr,int target) {
	        //write your code here
	      Arrays.sort(arr);
	      int l = 0, r = 1;
	      while(r < arr.length){
	          if(arr[r] - arr[l] == target){
	              System.out.println(arr[l]+" "+arr[r]);
	              return;
	          }else if(arr[r] - arr[l] < target){
	              r++;
	          }else{
	              l++;
	          }
	      }
	      System.out.println(-1);
	    }

}
