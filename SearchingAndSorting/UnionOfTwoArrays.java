package SearchingAndSorting;

import java.util.ArrayList;

public class UnionOfTwoArrays {
	  public static ArrayList<Integer> union(int[] a,int[] b) {
	        //write your code here
			int i = 0, j = 0;
			ArrayList<Integer> res = new ArrayList<>();
			while(i < a.length && j < b.length) {
				while(i != a.length - 1 && a[i] == a[i+1]) {
					i++;
				}
				while(j != b.length - 1 && b[j] == b[j+1]) {
					j++;
				}
				if(a[i] == b[j]) {
				    res.add(a[i]);
					i++;
					j++;
					
				}else if(a[i] < b[j]) {
					res.add(a[i]);
					i++;
				}else {
					res.add(b[j]);
					j++;
				}
			}
			while(i < a.length) {
			    while(i != a.length -1 && a[i] == a[i+1]){
			        i++;
			    }
				res.add(a[i]);
				i++;
			}
			while(j < b.length) {
			    while(j != b.length -1 && b[j] == b[j+1]){
			        j++;
			    }
				res.add(b[j]);
				j++;
			}
	        return res;
	    }

	    public static void main(String[]args) {
	        Scanner scn = new Scanner(System.in);
	        //input work
	        int n = scn.nextInt();
	        int[]a = new int[n];
	        for(int i=0; i < n;i++) {
	            a[i] = scn.nextInt();
	        }

	        int m = scn.nextInt();
	        int[]b = new int[m];
	        for(int i=0;i < m;i++) {
	            b[i] = scn.nextInt();
	        }

	        ArrayList<Integer>ans = union(a,b);

	        //print answer list
	        for(int val : ans) {
	            System.out.print(val + " ");
	        }
	        System.out.println();
	    }
}
