package timeComplexity;

//traverse from end to maintain order (
//stable sort) like 1, 1 so first 1 comes //first 2nd after that.
//smallrange but more freq count sort gives better perfm. --> TC- >> n + (max-min+1) + n
public class CountSort {
	public static void countSort(int[] arr, int min, int max) {
		   //write your code here
		int range = max - min + 1;
		int freq[] = new int[range];
		for(int i = 0; i < arr.length;i++) {
			freq[arr[i] - min]++;
		}
		for(int i = 1;i< freq.length;i++) {
			freq[i] += freq[i-1];
		}
		int ans[] = new int[arr.length];
		for(int i = arr.length - 1;i >= 0;i--) {
			int num = arr[i];
			int pSum = freq[num-min];
			ans[pSum-1] = num;
			freq[num]--;
		}
		  for(int i = 0;i < arr.length; i++){
		       arr[i] = ans[i];
		   }
		   
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
