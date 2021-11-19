package timeComplexity;


//avg case nlogn
//worst case -> T(n) = T(n-1)+k; -> n^2 (sorted in decres or incres)
//take last element as pivot rather than any element because it will put at last so it will be
//put at correct position before which all small and after all large..
public class QuickSort {
	public static void quickSort(int[] arr, int lo, int hi) {
		if(lo > hi) {
			return;
		}
		int pivot = arr[hi];
		int idx = partition(arr, lo, hi, pivot);
		quickSort(arr, lo, idx-1);
		quickSort(arr, idx+1, hi);
		
	}
	public static int partition(int[] arr, int lo, int hi, int pivot) {
		int j = lo;
		
		for(int i = lo;i <= hi;i++) {
			if(arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return j -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,2,5,8,11,2};
		quickSort(arr,0, arr.length-1);
		for(int val: arr) {
			System.out.println(val);
		}
	}

}
