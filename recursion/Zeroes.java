//think of base case when n = 0 or single digit
package recursion;

public class Zeroes {
	static int c = 0;
	static int func(int n) {
	
		if(n < 10) {
			if(n == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
	
		c++;
		
		return n%10 == 0? 1 + func(n/10) : func(n/10); 
	}
	
 public static void main(String args[]) {
	System.out.println(func(308090));
	System.out.println(c);
 }
}
