package Graph;

import java.util.Arrays;

public class Redundant2 {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		int[] indeg = new int[n+1];
		Arrays.fill(indeg, -1);
		int bl1 = -1, bl2 = -1;
		for(int i = 0;i < n;i++) {
			if(indeg[edges[i][1]] != -1) {
				bl1 = i;
				bl2 = edges[i][1];
				break;
			}
			
				indeg[edges[i][1]] = i;
		}
		int[] leaders = new int[n+1];
		int rank[] = new int[n+1];
		for(int i = 0;i < leaders.length;i++) {
			leaders[i] = i;
			rank[i] = 1;
		}
		for(int i = 0;i < edges.length;i++) {
			if(i == bl1) {
				continue;
			}
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			int set1 = find(leaders, v1);
			int set2 = find(leaders, v2);
			if(set1 == set2) {
				if(bl1 == -1) {
					return edges[i];
				}else {
					return edges[bl2];
				}
			}
		union(leaders, rank,set1, set2);
			
		}
		return edges[bl1];
    }
	 public int find(int[] leader, int x){
	        if(leader[x] == x){
	            return x;
	        }
	        int temp = find(leader, leader[x]);
	        leader[x] = temp;
	        return temp;
	    }
	    public void union(int[] setLeaders, int[] rank, int set1, int set2){
	        if(rank[set1] > rank[set2]){
	            setLeaders[set2] = set1; 
	        }else if(rank[set2] > rank[set1]){
	            setLeaders[set1] = set2;
	        }else{
	            setLeaders[set1] = set2;
	            rank[set2]++; 
	        }
	    }
}
