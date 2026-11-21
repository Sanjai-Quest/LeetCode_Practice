package DP;

import java.util.Scanner;

public class HouseRobberII {

    static int rob(int[] house) {
        int n = house.length;
        if(n == 1) return house[0];
        int case1 = robHelper(house, 0, n - 2);
        int case2 = robHelper(house, 1, n - 1);
        return Math.max(case2, case1);
    }

    static int robHelper(int[] house, int start, int end) {
        if(house.length == 1) return house[start];
        int prev2 = house[start];
        int prev1 = Math.max(house[start], house[start + 1]);
        for(int i = start + 2; i <= end; i++) {
            int current = Math.max(prev1, prev2 + house[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] house = new int[n];
        for(int i = 0; i < n; i++) house[i] = sc.nextInt();
        System.out.println(rob(house));
    }

}
