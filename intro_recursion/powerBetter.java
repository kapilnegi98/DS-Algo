package intro_recursion;

import java.util.Scanner;

public class powerBetter {
	 public static int power(int x, int n){
		 if(n == 0) {
			 return 1;
		 }
		 int val = power(x, n/2);
		val *= val;
		if(n%2!=0) {
			val *= x;
		}
		return val;
	    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		power(x,n);

	}

}
