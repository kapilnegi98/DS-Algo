package StackQueue;

import java.util.Stack;

public class DuplicateBrackets {
	
	public static boolean duplicateBrackets(String s) {
		Stack<Character> st = new Stack<>();
		for(int i = 0;i < s.length();i++) {
				if(s.charAt(i) == ')') {
					if(st.peek() == '(') {
						return true;
					}else {
						while(st.peek() != '(') {
							st.pop();
						}
						st.pop();
					}
				}else {
					st.push(s.charAt(i));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
