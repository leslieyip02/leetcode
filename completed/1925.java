class Solution {
    public int countTriples(int n) {
        int[] squares = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            squares[i] = i * i;
        }

        // s1, s2, s3, ..., sn
        // s1 [s2, s3, ..., sn]
        // s1 ,s2,[s3, ..., sn]
        // s1 [s2, s3, ...,]sn

        int count = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                int k = n;
                while (k > j) {
                    if (squares[i] + squares[j] == squares[k]) {
                        break;
                    }
                    k--;
                }

                if (j == k) {
                    continue;
                }

                if (squares[i] + squares[j] == squares[k]) {
                    // 2 permutations -> a^2 + b^2 = c^2 and b^2 + a^2 = c^2
                    count += 2;
                }
            }
        }
        return count;
    }
}
