package Arrays;

public class TrappingRainWater {

    static int trapWater(int[] heights) {
        int max = 0;
        int left = 0, right = 0;
        int start = 0, end = heights.length - 1;

        while(start < end) {
            left = Math.max(left, heights[start]);
            right = Math.max(right, heights[end]);

            if(left < right) {
                max += left - heights[start];
                start++;
            } else {
                max += right - heights[end];
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapWater(heights));
    }

}
