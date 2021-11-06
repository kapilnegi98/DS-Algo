package recursion;

import java.util.Arrays;

public class MergeSort {
static void merge(int[] arr, int left, int right, int mid) {
	int res[] = new int[right - left + 1];
	int l =left, r = mid+1, i= 0;
	while(l <= mid && r <= right) {
		if(arr[l] < arr[r]) {
			res[i] = arr[l];
			l++;
		}else {
			res[i] = arr[r];
			r++;
		}
		i++;
	}
	while(l <= mid) {
		res[i] = arr[l];
		l++;
		i++;
	}
	while(r <= right) {
		res[i] = arr[r];
		r++;
		i++;
	}
	l = left;
	for(int j = 0; j < res.length; j++) {
		arr[l++] = res[j];
	}
	
}
	
	static void mergeSort(int[] arr,int l,int h) {
		if(l < h) {
		int mid = l + (h - l)/2;
		 mergeSort(arr, l, mid);
		 mergeSort(arr, mid+ 1, h);
		 merge(arr, l, h, mid);
		}
	}
	
	public static void main(String args[]) {
		
		int arr[] = {3,14,0,6};
		mergeSort(arr, 0, arr.length-1);
		Arrays.stream(arr).forEach(i -> System.out.println(i));
	}
}
