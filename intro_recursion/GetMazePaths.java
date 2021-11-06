package intro_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		ArrayList<String> ans = new ArrayList<>();
		if(sr > dr || sc > dc) {
			return ans;

		}
		if(sr == dr && sc == dc) {
			ans.add("");
			return ans;
		}
		ArrayList<String> h = getMazePaths(sr, sc+1,dr,dc);
		ArrayList<String> v = getMazePaths(sr+1, sc, dr, dc);
		for(int i = 0; i < h.size();i++) {
			ans.add('h' + h.get(i));
		}
		for(int i = 0; i < v.size();i++) {
			ans.add('v' + v.get(i));
		}
		return ans;
	}

	
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		ArrayList<String> ans = new ArrayList<>();
		if(sr > dr || sc > dc) {
			return ans;
		}
		if(sr == dr && sc == dc) {
			ans.add("");
			return ans;
		}
		ArrayList<String> h = getMazePaths(sr, sc+1,dr,dc);
		ArrayList<String> v = getMazePaths(sr+1, sc, dr, dc);
		for(int i = 0; i < h.size();i++) {
			ans.add('h' + h.get(i));
		}
		for(int i = 0; i < v.size();i++) {
			ans.add('v' + v.get(i));
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	           int m = sc.nextInt();
	        System.out.println(getMazePaths(1,1,n,m));

	}

}
