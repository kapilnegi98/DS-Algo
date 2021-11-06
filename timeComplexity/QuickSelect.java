package timeComplexity;

import java.util.Scanner;

public class QuickSelect {
	public static int quickSelect(int[] arr, int lo, int hi, int k) {
		
		int p = findPivot(arr, lo, hi);
		if(p == k) {
			return arr[p];
		}else if(p < k) {
			return quickSelect(arr, p+1, hi, k);
		}else {
			return quickSelect(arr, lo, p-1, k);
		}
	}
	private static int findPivot(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		int i = l, j = l;
		int p = arr[h];
		while(i <= h) {
			
			if(arr[i] <= p) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				j++;
			}
			i++;
		}
		return j-1;
	}
	public static void main(String[] args) throws Exception {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }
	    int k = scn.nextInt();
	    System.out.println(quickSelect(arr,0,arr.length - 1,k - 1));
	  }

	}


