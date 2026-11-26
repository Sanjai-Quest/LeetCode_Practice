package DP;

import java.util.HashSet;
import java.util.List;
import java.util.*;

public class WordBreak {

    static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxlen = 0;
        for(String word : wordDict) {
            maxlen =  Math.max(maxlen, word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = i - 1; j >= Math.max(0, i - maxlen); j--) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";

        List<String> wordDict = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s, wordDict));
    }

}
