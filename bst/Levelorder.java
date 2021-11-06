package bst;

import java.util.Stack;

import org.w3c.dom.Node;

public class Levelorder {
	public static class Pair{
		Node node;
		int state;
		public Pair(Node n, int s) {
			node = n;
			state = s;
		}
	}
	  public static void iterativePrePostInTraversal(Node node) {
		    // write your code here
		  String pre = "";
		  String in = "";
		  String post = "";
		  Stack<Pair> st = new Stack<>();
		  st.push(new Pair(node, 0));
		  while(!st.isEmpty()) {
			  Pair top = st.peek();
			  if(top.state == 0) {
				  pre += top.node.data+" ";
				  if(top.node.left != null) {
					  st.push(new Pair(top.node.left, 0));
				  }
				  top.state += 1;
			  }else if(top.state == 1) {
				  in += top.node.data+"";
				  if(top.node.right != null) {
					  st.push(new Pair(top.node.right, 0));
				  }
				  top.state += 1;
			  }else {
				  post += top.node.data + " ";
				  st.pop();
			  }
		  }
		  System.out.println(pre);
		  System.out.println(in);
		  System.out.println(post);
		  }
}
