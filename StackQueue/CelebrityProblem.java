package StackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CelebrityProblem {
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();
	    Stack<Character> operator = new Stack<>();
	   
	    Stack<String> postfix = new Stack<>();
	    Stack<String> prefix = new Stack<>();
	    for(int i = 0;i < exp.length();i++) {
	    	char ch = exp.charAt(i);
	    	if(ch == '('){
	    	    operator.push(ch);
	    	    
	    	}else if(ch == ')'){
	    	    while(operator.peek() != '('){
	    	        char op = operator.pop();
	    	        String op1 = postfix.pop();
	    	        String op2 = postfix.pop();
	    	        postfix.add(op1 + op2 + op);
	    	        op1 = prefix.pop();
	    	        op2 = prefix.pop();
	    	        prefix.push(op + op1 + op2);
	    			
	    	    }
	    	    operator.pop();
	    	}
	    	else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	    		while(!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
	    			 char op = operator.pop();
		    	        String op1 = postfix.pop();
		    	        String op2 = postfix.pop();
		    	        postfix.add(op1 + op2 + op);
		    	        op1 = prefix.pop();
		    	        op2 = prefix.pop();
		    	        prefix.push(op + op1 + op2);
	    		}
	    		operator.push(ch);
	    	}else if(ch  >= 'a' && ch <= 'z') {
	    		postfix.push(ch + "");
	    		prefix.push(ch + "");
	    	}
	    }
	    while(!operator.isEmpty()){
	    	char op = operator.pop();
	        String op1 = postfix.pop();
	        String op2 = postfix.pop();
	        postfix.add(op1 + op2 + op);
	        op1 = prefix.pop();
	        op2 = prefix.pop();
	        prefix.push(op + op1 + op2);
	    }
	    
	    System.out.println(postfix.pop());
	    System.out.println(prefix.pop());
	   
	 }
	public static int precedence(char ch) {
		if(ch == '+' || ch == '-') {
			return 1;
		}else if(ch == '*' || ch == '/') {
			return 2;
		}else {
			return 0;
		}
	}
	public static int solve(int op1, int op2, char ch) {
		if(ch == '+') {
			return op1 + op2;
		}else if(ch == '-') {
			return op1 - op2;
		}else if(ch == '*') {
			return op1 * op2;
		}else {
			return op1 / op2;
		}
	}
	 }
}
