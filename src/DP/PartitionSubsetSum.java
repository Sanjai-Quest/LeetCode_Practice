package DP;

public class PartitionSubsetSum {

    static boolean partitionSum(int[] nums) {
        int target = 0;
        for(int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        target /= 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return solve(0, target, nums, memo);
    }

    static boolean solve(int index, int target, int[] nums, Boolean[][] memo) {
        if(target == 0) return true;
        if(nums.length == index) return false;

        if(memo[index][target] != null) return false;

        boolean task1 = false;
        if(nums[index] <= target) {
            task1 = solve(index + 1, target - nums[index], nums, memo);
        }
        boolean task2 = solve(index + 1, target, nums, memo);

        return memo[index][target] = task1 || task2;

    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8};
        System.out.println(partitionSum(nums));
    }

}
