package DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {

		Set<String> set = new HashSet<>();
		for(int i = 0;i < wordDict.size();i++) {
			set.add(wordDict.get(i));
		}
		boolean dp[] = new boolean[s.length()];
        for(int i = 0;i < dp.length;i++) {
        	for(int j = i;j >= 0;j--) {
        		s.substring(j,i+1);
        	}
        }
    }
}
