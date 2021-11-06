package DP;

/*
 * Let’s start by assuming that T(n-2) ≈ T(n-1). Don’t worry about why just yet – this will become apparent shortly.

Substituting the value of T(n-1) = T(n-2) into our relation T(n), we get:

T(n) = T(n-1) + T(n-1) + 1 = 2*T(n-1) + 1

By doing this, we have reduced T(n) into a much simpler recurrence. As a result, we can now solve for T(n) using backward substitution.


https://stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence

https://stackoverflow.com/questions/42617249/time-complexity-of-memoization-fibonacci
*
*/
public class Fibonacci {
	static int count = 0;
	static int fib(int n){
		count++;
		if(n == 1 || n ==0) {
			return n;
		}
		int ans = 0;
		ans  = fib(n-2);
		
		ans = ans + fib(n-1);
		
		return ans;
	}
	
	public static void main(String args[]) {
		System.out.println(fib(8));
		//System.out.println(count);
	}

}
