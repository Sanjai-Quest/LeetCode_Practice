package SlidingWindow;

public class MaxConsecutiveOnes {

    static int maxOnes(int[] nums) {
        int maxlen = 0;
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                len++;
                maxlen = Math.max(maxlen, len);
            }
            else len = 0;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 1};
        System.out.println(maxOnes(nums));

    }

}
