package recursion;

public class Staircase {
	static int func(int n) {
		
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		return func(n-1) + func(n-2) + func(n-3);
	}
	
	public static void main(String args[]) {
	
		System.out.println(func(4));
	}
}
