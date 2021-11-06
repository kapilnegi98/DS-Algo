package timeComplexity;

public class InsertionSort {
	
	public static void insert(int[] arr) {
		int n = arr.length;
		for(int i = 1;i < n;i++) {
			
			int j = i;
			while(j > 0 && arr[j] < arr[j-1]) {
				int t = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = t;
				j--;
			}
		}
		for(int i : arr) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert(new int[] {5,4,7,0,5,77});
		
	}

}
