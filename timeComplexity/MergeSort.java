package timeComplexity;

public class MergeSort {
	
	public static void mergeSort(int[] arr, int lo, int hi) {
	   if(lo >= hi) {
		   return;
	   }
		int mid = lo + (hi - lo)/2;
		mergeSort(arr, lo,mid);
		mergeSort(arr, mid+1, hi);
		merge(arr, lo, mid, hi);

	    
	  }
	public static void merge(int[] arr, int lo, int mid, int hi) {
		int temp[] = new int[hi-lo+1];
		int i=lo, j=mid+1, k = 0;
		while(i <= mid && j <= hi) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j <= hi) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		k = 0;
		for(int idx = lo;idx <= hi;idx++) {
			arr[idx] = temp[k];
			k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,2,5,8,11,2};
		mergeSort(arr,0, arr.length-1);
		for(int val: arr) {
			System.out.println(val);
		}
	}

}
