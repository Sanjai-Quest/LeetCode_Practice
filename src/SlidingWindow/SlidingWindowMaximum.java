package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    static int[] slidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int left = 0, right = 0;
        int index = 0;

        while(right < nums.length) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
                q.pollLast();
            }
            q.offerLast(right);
            if(left > q.peekFirst()) {
                q.pollFirst();
            }
            if(right + 1 >= k) {
                output[index++] = nums[q.peekFirst()];
                left++;
            }
            right++;

        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(slidingWindow(nums, k)));
    }
}
