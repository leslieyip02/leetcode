import java.util.*;

class Solution {
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            result.add(String.format("1/%d", i));
            for (int j = 2; j < i; j++) {
                if (gcd(i, j) != 1) {
                    continue;
                }

                result.add(String.format("%d/%d", j, i));
            }
        }
        return result;
    }
}
