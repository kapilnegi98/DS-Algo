package timeComplexity;

import java.util.Scanner;

public class SortDates {
	public static void sortDates(String[] arr) {
		   // write your code here
		//from start to end because ---see this ... 04/1996  and 08/1991
	    countSort(arr, 1000000, 100, 31);
	     countSort(arr, 10000, 100, 12);
	    countSort(arr, 1, 10000, 2500);
	   
		for(String i : arr) {
			System.out.println(i);
		}
	}
	public static void countSort(String[] arr, int div, int mod, int range) {
		   //write your code here
		
		int freq[] = new int[range+1];
		for(int i = 0; i < arr.length;i++) {
			freq[Integer.parseInt(arr[i])/div%mod]++;
		}
		for(int i = 1;i< freq.length;i++) {
			freq[i] += freq[i-1];
		}
		String ans[] = new String[arr.length];
		for(int i = arr.length - 1;i >= 0;i--) {
			int num = Integer.parseInt(arr[i])/div%mod;
			int pSum = freq[num];
			ans[pSum-1] = arr[i];
			freq[num]--;
		}
		  for(int i = 0;i < arr.length; i++){
		       arr[i] = ans[i];
		   }
		   
		  }

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    String[] arr = new String[n];
	    for (int i = 0; i < n; i++) {
	      String str = scn.next();
	      arr[i] = str;
	    }
	    sortDates(arr);
	  
	}

}
