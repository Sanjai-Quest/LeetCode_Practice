package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsAndBaskets {

    static int totalFruit(int[] fruits) {
        int left = 0, maxlen = 0;
        int k = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > k) {
                map.put(fruits[right], map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println(totalFruit(fruits));
    }

}
