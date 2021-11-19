package SearchingAndSorting;

public class Median {
	
    public static double find(int[]a1,int[]a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        if(n2 < n1) {
        	int temp[] = a1;
        	a1 = a2;
        	a2 = temp;
        	
        	n1 = a1.length;
        	n2 = a2.length;
        }
        int lo = 0, hi = n1;
        int te = n1 + n2;
        while(lo <= hi) {
        	int ali = lo +(hi - lo)/2;
        	int bli = (te + 1)/2 - ali;
        	int alm1 = ali == 0 ? Integer.MIN_VALUE : a1[ali - 1];
        	int al = ali == n1 ? Integer.MAX_VALUE : a1[ali];
        	int blm1 = bli == 0 ? Integer.MIN_VALUE : a2[bli - 1];
        	int bl = bli == n2 ? Integer.MAX_VALUE : a2[bli];
        	
        	if(alm1 <= bl && blm1 <= al) {
        	double median = 0;
        		if(te/2 == 0) {
        			return (Math.max(alm1, blm1) + Math.min(al, bl))/2;
        			
        		}else {
        			return (Math.max(alm1, blm1));
        		}
        	}else if(blm1 > al) {
        		lo = ali + 1;
        	}else {
        		hi = ali - 1;
        	}
        }
        return 0.0;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
