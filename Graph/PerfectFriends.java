package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriends {
	  public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int n = Integer.parseInt(br.readLine());
	      int k = Integer.parseInt(br.readLine());
	      
	      ArrayList<Integer>[] graph = new ArrayList[n];
	      for(int i = 0;i < n;i++) {
	    	  graph[i] = new ArrayList<Integer>);
	      }
	      for(int i = 0;i < k;i++) {
	    	  	String[] st = br.readLine().split(" ");
	    	  	graph[st[0]].add(st[1]);
	      }
	   }
}
