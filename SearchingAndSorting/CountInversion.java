package SearchingAndSorting;

import java.util.Scanner;
//brute force n^2.

//nlogn
public class CountInversion {
	public static int inversion(int[] arr,int lo,int hi) {
		if(lo == hi) {
			return 0;
		}
		int mid = lo + (hi - lo)/2;
		int lcount = inversion(arr, lo, mid);
		int rcount = inversion(arr, mid+1, hi);
		int count = findCount(arr, lo, mid, hi);
		return count + lcount + rcount;
	}
	public static int findCount(int[] arr, int lo, int mid, int hi) {
		int[] temp = new int[hi - lo + 1];
		int l = lo;
		int h = mid +1;
		int k = 0;
		int count =0;
		while(l <= mid && h <= hi) {
			if(arr[l] <= arr[h]) {
				temp[k] = arr[l];
			l++;
			}else {
				count += (mid - l + 1);
				temp[k] = arr[h];
				h++;
			}
			k++;
		}
		while(l <= mid) {
			temp[k] = arr[l];
			k++;
			l++;
		}
		while(h <= hi) {
			temp[k] = arr[h];
			k++;
			h++;
		}
		k = 0;
		for(int i = lo;i<=hi;i++) {
			arr[i] = temp[k];
			k++;
		}
		return count;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
			
		}
		System.out.println(inversion(arr,0,n-1));
		
	}
}
