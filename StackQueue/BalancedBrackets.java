package StackQueue;

import java.util.Stack;

public class BalancedBrackets {
	public static boolean BalancedBrackets(String s) {
		Stack<Character> st = new Stack<>();
		for(int i = 0;i < s.length();i++) {
			
		if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
			st.push(s.charAt(i));
		}
		if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
			if(!st.isEmpty() && isValid(st.peek(), s.charAt(i))) {
				st.pop();
			}else {
				return false;
			}
		}
		}
		if(!st.isEmpty()){
		    return false;
		}
		return true;
	}
	 public static boolean isValid(char top, char curr) {
		if(curr == ')' && top == '(' || curr == '}' && top == '{' || curr == ']' && top == '[') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		

	}

}
