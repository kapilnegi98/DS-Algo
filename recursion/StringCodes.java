package recursion;

public class StringCodes {
	static boolean func(String str, int i) {
		if(i == str.length()) {
			return true;
		}
		if(i == 0 && str.charAt(i) != 'a') {
			return false;
		}
	
		if(str.charAt(i) == 'a') {
			
			if(str.length() - i > 2 && str.charAt(i+1) == 'b' && str.charAt(i+2) == 'b') {
				return func(str, i+3);
			}else {
				return func(str, i+1);
			}
			
		}
		return false;
	
	}
	
 public static void main(String args[]) {
	 String s = "aabba";
	System.out.println(func(s, 0));

 }
}
