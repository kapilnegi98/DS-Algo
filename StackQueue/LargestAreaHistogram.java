package StackQueue;

import java.util.Stack;

/*We can also find the right min by traversing from the left side... 
*/
public class LargestAreaHistogram {
	   public int largestRectangleArea(int[] heights) {
		   Stack<Integer> st = new Stack<>();
		   int n = heights.length;
		   int[] left = new int[n];
		   int[] right = new int[n];
		   left[0] = -1;
		   st.push(heights[0]);
		   for(int i = 1;i < n;i++) {
			   while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
				   st.pop();
			   }
			   if(st.isEmpty()) {
				   left[i] = -1;
			   }else {
				   left[i] = st.peek();
			   }
			   st.push(i);
		   }
		   st = new Stack<>();
		   st.push(n);
		   right[n-1] = -1;
		   for(int i = heights.length - 2;i >= 0;i--) {
			   while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
				   st.pop();
			   }
			   if(st.isEmpty()) {
				   right[i] = n;
			   }else {
				   right[i] = st.peek();
			   }
			   st.push(i);
		   }
		   int maxArea = 0;
		   for(int i = 0;i < n;i++) {
			   maxArea = Math.max(maxArea, (right[i] - left[i] + 1)*heights[i]);
		   }
		   return maxArea;
		   
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
