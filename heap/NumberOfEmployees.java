package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberOfEmployees {
	
	 public static void main(String[] args){
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    HashMap<String, List<String>> mp = new HashMap<>();
		    String root = null;
		    
		    for(int i = 0;i < n;i++) {
		    	String emp = scn.next();
		    	String mgr = scn.next();
if(mgr.equals(emp)) {
		    	root = mgr;
		    	continue;
		    	}
		    	if(!mp.containsKey(mgr)) {
		    		mp.put(mgr, new ArrayList<>());
		    	}
		    	mp.get(mgr).add(emp);
		    	
		    }
		    System.out.println("****");
		    int a = sol(mp,root);
		    Map<String, Integer> ans = new HashMap<>();
		    for(Map.Entry<String, Integer> i : ans.entrySet()) {
		    	System.out.println(i.getKey()+" "+i.getValue());
		    }
			    
	  }
		    
		  }
	 public static int sol(HashMap<String, List<String>> mp, String root) {
		 if(!mp.containsKey(root)) {
			 return 1;
		 }
		 int count = 0;
		 for(String s: mp.get(root)) {
			 count += sol(mp, s);
		 }
		 return count + 1;
	 }
}
