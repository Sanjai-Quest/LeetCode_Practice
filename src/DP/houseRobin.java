package DP;

import java.util.Scanner;

public class houseRobin {

    static int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(nums[0] + nums[2], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);

        int take = 0, skip = 0;
        int max = 0;
        for(int i = 2; i < n; i++) {

            take = nums[i] + dp[i - 2];
            skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(rob(nums));
    }

}
