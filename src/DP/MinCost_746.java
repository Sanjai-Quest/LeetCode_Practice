package DP;

public class MinCost_746 {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0) return cost[0];
        if(n == 1) return cost[1];
        //O(n) Space and O(n) TC
//        int[] dp = new int[n];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//
//        for(int i = 2; i < n; i++) {
//            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
//        }
//        return Math.min(dp[n - 1], dp[n - 2]);

        //O(1) Space and O(n) TC
        int prev2 = cost[0];
        int prev1 = cost[1];
        for(int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);
    }


    public static void main(String[] args) {
        int n = 5;
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
