import java.util.*;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 1; i < books.length; i++) {
            // new shelf
            int width = books[i][0];
            int maxHeight = books[i][1];
            dp[i + 1] = dp[i] + maxHeight;

            // add prev to current shelf
            for (int j = i - 1; j >= 0; j--) {
                if (width + books[j][0] > shelfWidth) {
                    break;
                }

                width += books[j][0];
                maxHeight = Math.max(books[j][1], maxHeight);
                dp[i + 1] = Math.min(dp[j] + maxHeight, dp[i + 1]);
            }
        }

        return dp[books.length];
    }
}
