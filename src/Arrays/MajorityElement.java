package Arrays;

public class MajorityElement {

    static int majorityElement(int[] nums) {
        int candidate = 0;
        int freq = 0;

        for(int n : nums) {
            if(freq == 0) {
                candidate = n;
            } else if(candidate == n) {
                freq++;
            }
        }
        freq = 0;
        for(int n : nums) {
            if(candidate == n) {
                freq++;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 3, 1};
        System.out.println(majorityElement(nums));
    }

}
