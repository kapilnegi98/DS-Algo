package intro_recursion;

public class TOH {
	 public static void toh(int n, int t1, int t2, int t3){
	      if(n == 0) {
	    	  return;
	      }
		 toh(n-1, t1, t3, t2);
		 System.out.println(n+"["+t1+"->"+t2+"]");
		 toh(n-1, t3,t2,t1);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
