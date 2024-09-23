import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i == 0 ? 1 : dp[i - 1] + 1;
            for (int j = 0 ; j <= i; j++) {
                if (!set.contains(s.substring(j, i + 1))) {
                    continue;
                }
                dp[i] = j == 0 ? 0 : Math.min(dp[j - 1], dp[i]);
            }
        }
        return dp[dp.length - 1];
    }
}
