package DP;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class UniqueBinaryStrings2 {
	   public List<TreeNode> generateTrees(int n) {
	        
	        List<TreeNode> ans = sol(1, n);
	        
	        return ans;
	    }
	    public List<TreeNode> sol(int start, int end){
	        
	        List<TreeNode> ans = new ArrayList<>();
	        if(start > end){
	            ans.add(null);
	            return ans;
	        }
	        for(int i = start; i <= end;i++){
	            List<TreeNode> left = sol(start,i-1);
	            List<TreeNode> right = sol(i+1, end);
	            for(TreeNode l : left){
	                for(TreeNode r: right){
	                    TreeNode root = new TreeNode(i, l,r);
	                ans.add(root);
	                }
	            }
	        }
	        return ans;
	    }
}
