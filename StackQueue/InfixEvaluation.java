package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  String exp = br.readLine();
		  Stack<Integer> st1 = new Stack<>();
		  Stack<Character> st2 = new Stack<>();
		  for(int i= 0 ;i < exp.length();i++) {
			  char ch = exp.charAt(i);
			  if(ch=='(') {
				  st2.push(ch);
			  }else if(ch == '+' || ch == '-' || ch=='/' || ch=='*') {
				 while(precedence(ch) <= st2.peek()) {
					 int a = st1.pop();
					 int b = st1.pop();
					 char op = st2.pop();
					 int res = solve(a,b,op);
					 st1.push(res);
				 }
				 st2.push(ch);
			  }else if(ch == ')') {
				  while(st2.peek() != '(') {
						 int a = st1.pop();
						 int b = st1.pop();
						 char op = st2.pop();
						 int res = solve(a,b,op);
						 st1.push(res);
					 }
				  st2.pop();
			  }else {
				  st1.push(ch-'0');
			  }
		  }
		  
		  
	}
	public static int precedence(char ch) {
		if(ch == '+' || ch == '-') {
			return 1;
		}else {
			return 2;
		}
		
	}
	public static int solve(int a, int b, char ch) {
		if(ch == '+') {
			return a + b;
		}else if(ch == '-'){
			return a - b;
		}else if(ch == '/'){
			return a / b;
		}else{
			return a * b;
		}
	}

}
