package DP;

public class PaintHouses {
	
	 public static int recursion(int[][] costs, int idx, int prevPaint) {
			if(idx == costs.length) {
				return 0;
			}
			int ans1 = 0, ans2 = 0;
			if(prevPaint == 0) {
				ans1 = costs[idx][1] + recursion(costs, idx+1, 1);
				ans2 = costs[idx][2] + recursion(costs, idx+1, 2);
			}
			if(prevPaint == 1) {
				ans1 = costs[idx][0] + recursion(costs, idx+1, 0);
				ans2 = costs[idx][2] + recursion(costs, idx+1, 2);
			}
			if(prevPaint == 2) {
				ans1 = costs[idx][0] + recursion(costs, idx+1, 0);
				ans2 = costs[idx][1] + recursion(costs, idx+1, 1);
			}
			return Math.min(ans1,  ans2);
		}
	
 public static int minCost(int[][] costs) {
 	  	 
		 int dp[][] = new int[costs.length][costs[0].length];
		 int minCost = 0, min = Integer.MAX_VALUE;
		for(int i = 0;i < dp[0].length;i++) {
			dp[0][i] = costs[0][i];
		
		}
		
		for(int i = 1;i <dp.length;i++) {
			dp[i][0] =costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = costs[i][1] +Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = costs[i][2] +Math.min(dp[i-1][0], dp[i-1][1]);
		}
			minCost = Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
		return minCost;
		 
 	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scn= new Scanner(System.in);

		int n=scn.nextInt();
        int[][] costs= new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                costs[i][j]=scn.nextInt();
            }
        }
		 int ans1 = costs[0][0] + recursion(costs, 1, 0);
         int ans2 = costs[0][1] + recursion(costs, 1, 1);
         int ans3 = costs[0][2] + recursion(costs, 1, 2);
         System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
	}

}
