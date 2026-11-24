package SlidingWindow;

public class MaxConsecutiveOnesIII {

    static int maxOnesIII(int[] nums, int k) {
        int left = 0; //left pointer which moves when 0 is found in the array
        int maxlen = 0; //keeps track of the maximum ones found so far
        int zerocount = 0; //Counts zero in the window so that whenever the zerocount is greater than k, it helps to move the left pointer to the next...

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zerocount++;
            while(zerocount > k) {
                if(nums[left] == 0) {
                    zerocount--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 1};
        int k = 2;
        System.out.println(maxOnesIII(nums, k));


    }

}
