package bst;

import java.util.ArrayList;

import org.w3c.dom.Node;

public class PrintKDistanceAway {
	
	public static ArrayList<Node> nodeToRootPath(Node node, int data){
		ArrayList<Node> ans = new ArrayList<Node>();
		if(node ==null) {
			return ans;
		}
		if(node.data == data) {
			ans.add(node);
			return ans;
		}
		ArrayList<Integer> leftAns = nodeToRootPath(node.left,data);
		if(leftAns.size() != 0) {
			leftAns.add(node);
			return leftAns;
		}
		ArrayList<Integer> rightAns = nodeToRootPath(node.right,data);
		if(rightAns.size() != 0) {
			rightAns.add(node);
			return rightAns;
		}
		return ans;
	}
	public static void kLevelDown(Node node, int k, Node blocker) {
	if(node == null) {
		return;
	}
	if(node == blocker) {
		return;
	}
		if(k == 0) {
			System.out.println(node.data);
			return;
		}
		kLevelDown(node.left,k-1);
		kLevelDown(node.right,k-1);
	}
	  public static void printKNodesFar(Node node, int data, int k) {
		    // write your code here
		  ArrayList<Node> path = nodeToRootPath(node, data);
		  for(int i = 0;i < path.size();i++) {
			  kLevelDown(path[i], k-i, path[i-1]);
		  }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
