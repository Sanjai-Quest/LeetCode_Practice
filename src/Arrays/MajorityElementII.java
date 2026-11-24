package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    static List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for(int n : nums) {
            if(n == candidate1) count1++;
            else if(n == candidate2) count2++;
            else if(count1 == 0) {
                candidate1 = n;
                count1 = 1;
            }
            else if(count2 == 0) {
                candidate2 = n;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums) {
            if(n == candidate1) count1++;
            else if(n == candidate2) count2++;
        }
        List<Integer> list = new ArrayList<>();
        if(count1 > nums.length / 3) list.add(candidate1);
        if(count2 > nums.length / 3) list.add(candidate2);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 3, 2, 2, 3, 2};
        System.out.println(majorityElement(nums));
    }

}
