package timeComplexity;

public class RadixSort {
	public static void radixSort(int[] arr) {
		int max = -1;
	for(int i = 0;i < arr.length;i++) {
		max = Math.max(max, arr[i]);
		}
	int p = 1;
	while(max != 0) {
		countSort(arr, p);
		p *= 10;
		max = max/10;
	}
	for(int i : arr) {
		System.out.println(i);
	}
	}
	public static void countSort(int[] arr, int p) {
		
		int freq[] = new int[10];
		for(int i = 0;i<arr.length;i++) {
			freq[arr[i]/p%10]++;
		}
		for(int i = 1;i < freq.length;i++) {
			freq[i] += freq[i-1];
		}
		int ans[] = new int[arr.length];
		for(int i = arr.length-1; i >= 0; i--) {
			int num = arr[i];
			int pSum = freq[arr[i]/p%10];
			ans[pSum-1] = num;
			freq[arr[i]/p%10]--;
		}
		for(int i = 0; i < arr.length;i++) {
			arr[i] = ans[i];
		}
	
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			radixSort(new int[] {23,105,6,12,71,568,321,40});
	}

}
