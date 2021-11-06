//can be done using breadth first approach also.
package recursion;

public class Subset {
	static char getCode(int x) {
		return (char) (96 + x);
	}
	static void func(String input, String output) {
	
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		char x = getCode(input.charAt(0) - '0');
			func(input.substring(1), output + x);
			if(input.length() >= 2) {
				if((input.charAt(0)-'0')*10 + (input.charAt(1)-'0') < 26) {
					char nextChar = getCode((input.charAt(0)-'0')*10 + (input.charAt(1)-'0'));
					func(input.substring(2), output + nextChar);	
				}
	
			}
	
	}
	
 public static void main(String args[]) {
	int[] arr = {1,2,3};
	func("1123", "");

 }
}
