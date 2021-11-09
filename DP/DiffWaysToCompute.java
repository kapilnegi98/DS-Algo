package DP;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
	 public List<Integer> diffWaysToCompute(String exp) {
	       	List<Integer> ans = new ArrayList<>();
	       	if(exp.length() <= 1) {
	       		ans.add(Integer.parseInt(exp));
	       		return ans;
	       	}
		 for(int i = 0;i < exp.length();i++) {
			 char ch = exp.charAt(i);
			 if(ch == '+' || ch == '-' || ch == '*') {
				 List<Integer> left = diffWaysToCompute(exp.substring(0,i));
				 List<Integer> right = diffWaysToCompute(exp.substring(i+1));
				 for(int l: left) {
					 for(int r : right) {
						 if(ch == '+') {
							 ans.add(l + r);
						 }else if(ch == '-') {
							 ans.add(l - r);
						 }else {
							 ans.add(l *r);
						 }
					 }
				 }
			 }
		 }
		 return ans;
	    }
}
