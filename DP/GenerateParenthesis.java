package DP;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	 public List<String> generateParenthesis(int n) {
	      List<String> ans = new ArrayList<>();
         sol(2*n, 0, 0, "", ans);
         return ans;
 }
 public void sol(int n, int open, int close, String asf, List<String> ans){
    if(n == 0) {
    	ans.add(asf);
    	return;
    }
    sol(n-1, open+1, close, asf+"(", ans);
    if(open > close) {
    sol(n-1,open, close+1, asf+")", ans);
    }
    }
}
