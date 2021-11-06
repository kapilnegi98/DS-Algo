/*
1. for(s: arr) if arr is null then give null pointer excep
2. 
*/package intro_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintEncoding {
	public static char getValue(char s) {
		char c = (char) ('a' + (s - '0') -1);
		
		return c;
	}
	public static char getValue(String s) {
		char c = (char) ('a' + Integer.parseInt(s) -1);
		
		return c;
	}
	 public static ArrayList<String> printEncodings(String str) {
		ArrayList<String> ans = new ArrayList<>();
		if(str.length() == 0) {
			
			ans.add("");
			return ans;
		}
		 ArrayList<String> a1 = printEncodings(str.substring(1));
		 for(String s: a1) {
			 ans.add(getValue(str.charAt(0)) + s); // instead of char extract as a string can work.
			 
		 }
		
		 if(str.length() >= 2 && Integer.parseInt(str.substring(0, 2)) <= 26) {
			 ArrayList<String> a2 = printEncodings(str.substring(2));
			for(String s: a2) {
				 ans.add(getValue(str.substring(0,2)) + s);
			 }
			 
		 }
		 
		
		 return ans;
	 }

	public static void main(String[] args) {		
		
		 Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	        System.out.println(printEncodings(s));
	
		
	}

}
