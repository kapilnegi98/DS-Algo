package bst;

public class PrintKLevelDown {
	
	//other method using levelorder.
	public static void printKLevelsDown(Node node, int k){
	    
	    if(node == null){
	        return;
	    }
	    if(k==0){
	        System.out.println(node.data);
	        return;
	    }
	    
	    printKLevelsDown(node.left,k-1);
	    printKLevelsDown(node.right,k-1);
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
