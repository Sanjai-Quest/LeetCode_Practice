package DP;

import java.util.HashMap;
import java.util.Map;

public class TallestBillboard {

    static int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for(int rod : rods) {
            Map<Integer, Integer> next = new HashMap<>(dp);
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int diff = entry.getKey();
                int shorter = entry.getValue();
                int newDiff = diff + rod;
                int newShort = shorter;

                next.put(newDiff, Math.max(next.getOrDefault(newDiff, 0), newShort));
                int shortDiff = Math.abs(diff - rod);
                int shortHeight = shorter + Math.min(diff, rod);

                next.put(shortDiff, Math.max(next.getOrDefault(shortDiff, 0), shortHeight));

            }
            dp = next;
        }
        return dp.get(0);
    }

    public static void main(String[] args) {
        int[] rods = {1, 2, 3, 6};
        System.out.println(tallestBillboard(rods));
    }

}
