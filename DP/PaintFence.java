package DP;

public class PaintFence {
	
	public static int recursive(int n, int k) {
		if(n==2) {
		return k + (k * (k-1)); //(k-1) must be in brackets
	}
	if(n==1) {
		return k;
	}

	
	return ((k-1) * recursive(n-1, k)) + ((k-1) * recursive(n-2, k));
}
	public static int tab(int n, int k) {
		
		int same = 0;
		int diff = 3;
		
		for(int i = 1;i < n;i++) {
			int newSame = diff;
			//(k-1) must be in brackets
			int newDiff = (same + diff) * (k-1);
			same = newSame;
			diff = newDiff;
		}
		return same + diff;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
