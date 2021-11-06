package hashmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// if we add all elemnts and then remove k elemets then TC will be nlogn.beacuse in PQ
//add and remove is logn where n is no. of elements. so for entering n elements using a
//loop will be nlogn. in below approach is nlognK.
public class Klargest {
	  public static void main(String[] args) throws Exception {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int i = 0;i < k;i++) {
    	  pq.add(arr[i]);
      }
      for(int i = k;i < n;i++) {
    	  if(arr[i] > pq.peek()) {
    		  pq.poll();
    		  pq.add(arr[i]);
    	  }
      }
      while(!pq.isEmpty()) {
    	  System.out.println(pq.poll());
      }
	  }
      public static void main2(String[] args) throws Exception {
         
    	      int[] arr = new int[n];

    	      for (int i = 0; i < n; i++) {
    	         arr[i] = Integer.parseInt(br.readLine());
    	      }

    	      int k = Integer.parseInt(br.readLine());
    	      // write your code here
    	      Arrays.sort(arr);
    	      int l = 0, r = arr.length-1;
    	      while(l < r) {
    	    	  int temp = arr[l];
    	    	  arr[l] = arr[r];
    	    	  arr[r]  = temp;
    	    	  l++;
    	    	  r--;
    	      }
    	      for(int i = k-1;i >= 0;i--) {
    	    	  System.out.println(arr[i]);
    	      }
    }
}
