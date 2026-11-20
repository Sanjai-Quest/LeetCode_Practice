package DP;

public class MinimumCost {

    static int minCost(int[] cost) {
//        int n = cost.length;
//        if(n == 1) return cost[0];
//        int[] dp = new int[n];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for(int i = 2; i < n; i++) {
//            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
//        }
//        return dp[n - 1];

        int n = cost.length;
        if(n == 0) return cost[0];
        if(n == 1) return cost[1];

        int prev2 = cost[0];
        int prev1 = cost[1];

        for(int i = 2; i < n; i++) {
            int current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;

    }

    public static void main(String[] args) {
        int n = 5;
        int[] cost = {10, 15, 20};
        System.out.println(minCost(cost));
    }

}
