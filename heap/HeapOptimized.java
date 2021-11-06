package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HeapOptimized {
	public static class PriorityQueue {
	    ArrayList<Integer> data;

	    public PriorityQueue() {
	      data = new ArrayList<>();
	    }
	    public PriorityQueue(int arr[]) {
	    	data = new ArrayList<>();
	    	for(int i = arr.length/2-1;i >= 0;i--) {
	    		downHeapify(i);
	    	}
	    }

	    public void add(int val) {
	      // write your code here
	      data.add(val);
	      int idx = data.size()-1;
	      upHeapify(idx);
	    }
	    public void upHeapify(int ci){
	        if(ci == 0){
	            return;
	        }
	        int pi = (ci-1)/2;
	        if(data.get(pi) > data.get(ci)){
	            int temp = data.get(pi);
	            data.set(pi, data.get(ci));
	            data.set(ci, temp);
	            upHeapify(pi);
	        }
	    }

	    public int remove() {
	      // write your code here
	       if(data.size() == 0){
	          System.out.println("Underflow");
	          return -1;
	      }
	      int temp = data.get(0);
	      data.set(0, data.get(data.size()-1));
	      data.set(data.size()-1, temp);
	      int rem = data.remove(data.size()-1);
	      downHeapify(0);
	      return rem;
	    }
	    public void downHeapify(int pi){
	        
	        int ch1 = pi*2 + 1;
	        int ch2 = pi*2 + 2;
	        // if(ch1 >= data.size() || ch2 >= data.size()){
	        //     return;
	        // }
	        // int min = data.get(ch1) < data.get(pi)? (data.get(ch1) < data.get(ch2)? ch1:ch2): (data.get(pi) < data.get(ch2) ? pi : ch2); 
	    //because if only one child then it will fail;
	    int min = pi;
	    if(ch1 < data.size() && data.get(ch1) < data.get(min)){
	        min = ch1;
	    }
	    if(ch2 < data.size() && data.get(ch2) < data.get(min)){
	        min = ch2;
	    }
	    if(min == pi){
	        return;
	    }
	     int temp1 = data.get(pi);
	     int temp2 = data.get(min);
	     data.set(pi, temp2);
	     data.set(min, temp1);
	     downHeapify(min);
	     }

	    public int peek() {
	      // write your code here
	      if(data.size() == 0){
	          System.out.println("Underflow");
	          return -1;
	      }
	      return data.get(0);
	    }

	    public int size() {
	      // write your code here
	      return data.size();
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue qu = new PriorityQueue();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("add")) {
	        int val = Integer.parseInt(str.split(" ")[1]);
	        qu.add(val);
	      } else if (str.startsWith("remove")) {
	        int val = qu.remove();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("peek")) {
	        int val = qu.peek();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("size")) {
	        System.out.println(qu.size());
	      }
	      str = br.readLine();
	    }
	  }
	}
