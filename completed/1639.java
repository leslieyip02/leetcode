import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();

        List<Map<Character, Integer>> dictionary = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> counts = new HashMap<>();
            for (String word : words) {
                char c = word.charAt(i);
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
            dictionary.add(counts);
        }
        char[] targetArray = target.toCharArray();

        int[][] dp = new int[m][n];
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == target.charAt(0)) {
                dp[0][0]++;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < Math.min(i + 1, n); j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % M;

                int count = dictionary.get(i).getOrDefault(targetArray[j], 0);
                if (count == 0) {
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = (dp[i][j] + count) % M;
                } else {
                    dp[i][j] = (int) ((dp[i][j] + (long) dp[i - 1][j - 1] * count) % M);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
