package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	 public List<String> wordBreak(String s, List<String> wordDict) {
		 	Set<String> set = new HashSet<String>();
		 	for(int i = 0;i < wordDict.size();i++) {
		 		set.add(wordDict.get(i));
		 	}
		 	List<String> ans = new ArrayList<>();
		 	helper(s, 0, set, "", ans);
		 	return ans;
	    }
	 public void helper(String s, int idx, Set<String> set, String asf, List<String> ans) {
		 if(idx == s.length()) {
			 asf = asf.substring(0, asf.length() - 1);
			 ans.add(asf);
			 return;
		 }
		 for(int i = idx;i < s.length();i++) {
			 if(set.contains(s.substring(idx, i+1))) {
				 helper(s, i+1,set, asf + s.substring(idx,i+1)+" ",ans);
			 }
		 }
	 }
	    
}
