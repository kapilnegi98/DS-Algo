import java.util.PriorityQueue;

public class PCMMarks {
	public static class Triplet implements Comparable<Triplet>{
		int p,c,m;
		public Triplet(int p, int c, int m) {
			this.p = p;
			this.c = c;
			this.m = m;
		}
		@Override
		public int compareTo(Triplet o) {
			if(this.p == o.p) {
				if(this.c == o.c) {
					return this.m - o.m;
				}else {
					return this.c - o.c;
				}
			}else {
				return this.p  - o.p;
			}
		}
		
	}
	  public static void customSort(int[]phy,int[]chem,int[]math) {
		  //better to create an array and then sort.
	      PriorityQueue<Triplet> pq = new PriorityQueue<>();  
		  for(int i = 0;i < phy.length;i++) {
	        	pq.add(new Triplet(phy[i], chem[i], math[i]));
	        }
		  int i = 0;
		  while(!pq.isEmpty()) {
			  Triplet rem = pq.remove();
			  phy[i] = rem.p;
			  chem[i] = rem.c;
			  math[i] = rem.m;
			  i++;
		  }
	        
	    }
}
