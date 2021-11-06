package recursion;

public class StringToNumber {

	static int func(String s) {
		if(s.length() == 1) {
			return s.charAt(0) - '0';
		}
		int smallAns = func(s.substring(0, s.length()-1));
		return smallAns*10 + s.charAt(s.length() - 1) - '0';
	}
	
	public static void main(String args[]) {
	String s = "3456";
		System.out.println(func(s));
	}

}
