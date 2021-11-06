package StackQueue;

import java.util.Stack;

public class NextGreaterElement {
	public static int[] solve(int[] arr){
		   // TC---> 2n --> O(n)  each element will push 1 time and pop 1 time. 
		   int[] res = new int[arr.length];
		   		Stack<Integer> st = new Stack<>();
		   		st.push(arr[arr.length-1]);
		   		res[arr.length-1] = -1;
		        for(int i = arr.length-2;i >= 0;i--){
		            while(!st.isEmpty() && st.peek() <= arr[i]){
		                st.pop();
		            }
		            if(st.isEmpty()){
		                res[i] = -1;
		            }else{
		                res[i] = st.peek();
		            }
		            st.push(arr[i]);
		        }
		   return res;
		 }
	public static int[] leftToRight(int[] arr){
		   
		   int[] res = new int[arr.length];
	   		Stack<Integer> st = new Stack<>();
	   		st.push(0);
	   		for(int i = 1;i < arr.length;i++) {
	   			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
	   				res[st.pop()] = arr[i];
	   			}
	   			st.push(i);
	   		}
	   		while(!st.isEmpty()) {
	   			res[st.pop()] = -1;
	   		}
		   return res;
		 }
	
	public static void nextGreat() {
		
	}
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		

	}

}
