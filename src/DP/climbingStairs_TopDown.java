package DP;

public class climbingStairs_TopDown {

    static int climbStair(int n, int[] memos) {
        if(n == 0 || n == 1) return 1;
        if(memos[n] != 0) return memos[n];
        memos[n] = climbStair(n - 1, memos) + climbStair(n - 2, memos);
        return memos[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] memos = new int[n + 1];
        System.out.println(climbStair(n, memos));
    }

}
