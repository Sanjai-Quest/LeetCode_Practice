package Arrays;

public class ContainerWithMaxWater {

    static int maxWater(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while(left < right) {
            int width = right - left;
            int currArea = width * Math.min(heights[left], heights[right]);
            max = Math.max(currArea, max);

            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {8,7,2,1};
        System.out.println(maxWater(heights));
    }

}
