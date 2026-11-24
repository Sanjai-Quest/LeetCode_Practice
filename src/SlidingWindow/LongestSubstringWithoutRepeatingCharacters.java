package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    static int MaxLen(String s) {
        Map<Character, Integer> map = new HashMap<>(256);
        int left = 0, maxlen = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            int len = right - left + 1;
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "abcdaghij";
        System.out.println(MaxLen(s));
    }

}
