package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindowMaximum {
	 public int[] maxSlidingWindow2(int[] nums, int k) {
			Deque<Integer> q = new ArrayDeque<>();
			 int[] ans = new int[nums.length - k+1];
			 	for(int i = 0;i < k;i++) {
			 		while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
			 			q.removeLast();
			 		}
			 		q.addLast(i);
			 	}
	        ans[0] = nums[q.peekFirst()];
			 	for(int i = k; i < nums.length;i++) {
			 		while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
			 			q.removeLast();
			 		}
			 		q.addLast(i);
			 		if(q.peek() <= i- k) {
			 			q.removeFirst();
			 		}
			 		ans[i-k+1] = nums[q.peekFirst()];
			 	}
			 	return ans;
	    }
 	public int[] nextGreater(int[] nums) {
		Stack<Integer> st = new Stack<>();
		int[] right = new int[nums.length];
		for(int i = nums.length - 1;i>=0;i--) {
			while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				right[i] = nums.length;
			}else {
				right[i] = st.peek();
			}
			st.push(i);
		}
        
		return right;
	}
	 public int[] maxSlidingWindow(int[] nums, int k) {
		 	int next[] = nextGreater(nums);
		 	int j = 0;
		 	int ans[] = new int[nums.length-k+1];
		 	for(int i = 0;i <= nums.length - k;i++) {
		 		if(j < i) {
		 			j = i;
		 		}
		 		while(next[j] < i+k) {
		 			j = next[j];
		 		}
		 		ans[i] = nums[j];
		 	}
		 	return ans;
		 	
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
