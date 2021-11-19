package SearchingAndSorting;

public class KokoBanana {
	
	   public static int minEatingSpeed(int[]piles,int h) {
	        //write your code here
		  
	        int maxVal = 0;
	        for(int i = 0;i < piles.length;i++){
	            maxVal = Math.max(maxVal, piles[i]);
	        }
	        int lo = 1, hi = maxVal;
	        int k = hi;
	        while(lo <= hi){
	            int mid = lo + (hi - lo)/2;
	            
	            int hours = 0;
	            for(int i = 0;i < piles.length;i++){
	                hours += Math.ceil(piles[i]/mid);
	            }
	            System.out.println(hours);
	            if(hours > h){
	                lo = mid + 1;
	            }else{
	                k = Math.min(k, mid);
	                hi = mid - 1;
	            }
	            
	            
	        }
	        return k;
	   }
	   public static void main(String args[]) {
		   double a = 2.34;
		   int b = 1;
		 b += a;
		   double c = (a + b);
		   System.out.println(b);
	   }
}
