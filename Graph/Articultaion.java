package Graph;

import java.util.ArrayList;
import java.util.Scanner;

//don't use count for getting no. of articulation point because it will increse count if
//one point removal give more than two connected comp.
public class Articultaion {

	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i = 0;i < n;i++) {
				graph.add(new ArrayList<>());
			}
			for(int i = 0;i < m;i++) {
				int v1 = sc.nextInt()-1;
				int v2 = sc.nextInt()-1;
				graph.get(v1).add(v2);
				graph.get(v2).add(v1);
			}
			boolean[] visited = new boolean[n];
			int[] parent = new int[n];
			int[] dis = new int[n];
			int[] low = new int[n];
			boolean[] art= new boolean[n];
			parent[0] = -1;
			dfsArticulation(graph,0,dis,low,parent,visited, art);
			int count = 0;
			 for(boolean i : art) {
				 if(i == true) {
					 count++;
				 }
			 }
			 System.out.println(count);

	}
		static int time = 0;
		public static void dfsArticulation(ArrayList<ArrayList<Integer>> graph,int src, int[] dis,
				int[] low, int[] parent, boolean[] visited, boolean[] art) {
			dis[src] = time;
			low[src] = time;
			time++;
			visited[src] = true;
			int count = 0;
			for(int nbr: graph.get(src)) {
		
				if(visited[nbr] == true && parent[src] != nbr) {
					low[src] = Math.min(dis[nbr], low[src]);
				}else if(visited[nbr] == false) {
			   
				 
					parent[nbr] = src;
					dfsArticulation(graph, nbr, dis, low, parent, visited, art);
						low[src] = Math.min(low[src], low[nbr]);
					 count++;
					if(parent[src] == -1){
					    if(count > 1)
			            art[src] = true;
			    }else{
				
					if(dis[src] <= low[nbr]) {
						art[src] = true;
					}
			    }
				}
			}
		}

	
}
