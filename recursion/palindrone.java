//second method is func(str.substring(1, str.length() - 1)) and base case input.length < 1
package recursion;

public class palindrone {
	static String func(String str) {
		if(str.length() == 0) {
			return "";
		}
		return func(str.substring(1)) + str.charAt(0);
	
	}
	
 public static void main(String args[]) {
	 String s = "racecar";
	System.out.println(s.equals(func(s)));
	String p = "";
	System.out.println(p.charAt(0));

 }
}
