package intro_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getKpc {
	 static String[] keys = {".;", "abc", "def", "ghi", "jkl","mno", "pqrs", "tu", "vwx", "yz"};
	 public static ArrayList<String> getKPC(String str) {
		 ArrayList<String> ans = new ArrayList<>();
		 if(str.length() == 0) {
			 ans.add("");
			return ans;
		 }
		
		 ArrayList<String> smallAns = getKPC(str.substring(1));
		 String code = keys[str.charAt(0) - '0'];
		 for(int i = 0; i < code.length(); i++) {
			 for(int j = 0;j < smallAns.size();j++)
			 	ans.add(code.charAt(i) + smallAns.get(j));
		 }
		 return ans;
		 
	 }
	

	  public static void main(String[] args) throws Exception {
		  Scanner sc = new Scanner(System.in);
		 	        String str = sc.nextLine();
		 	        System.out.println(getKPC(str));
		     }
}
