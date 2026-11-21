package DP;

import java.util.Arrays;
import java.util.Scanner;

public class coinChange {

    static int change(int[] coins, int amount) {

        int n = coins.length;
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    int candidate = dp[i - coin] + 1;
                    dp[i] = Math.min(dp[i], candidate);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        System.out.println(change(coins, amount));

    }

}
