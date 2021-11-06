package DP;

import java.util.Stack;

public class LongestValidParenthesis {
		
	 public int longestValidParentheses(String s) {
		 Stack<Integer> st = new Stack<>();
		 int max = 0;
		 for(int i = 0;i < s.length();i++) {
			 if(s.charAt(i) == '(') {
				 st.push(i);
			 }else {
				 if(!st.isEmpty() && s.charAt(st.peek()) == '(') {
					 st.pop();
					 int len = st.isEmpty() ? i+1 : i - st.peek();
					 max = Math.max(max,  len);
				 }else {
					 st.push(i);
				 }
				 
			 }
		 }
		 return max;
	  }
}
