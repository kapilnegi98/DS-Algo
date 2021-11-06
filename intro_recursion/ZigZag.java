package intro_recursion;

import java.util.Scanner;

public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		zigzag(n);
	}
	public static void zigzag(int n) {
		
		if(n == 0) {
			return;
		}
		
		System.out.println(n);
		zigzag(n-1);
		System.out.println(n);
		zigzag(n-1);
		System.out.println(n);
	}

}
