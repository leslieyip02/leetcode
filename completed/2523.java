class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * 2; j <= right; j += i) {
                isPrime[j] = false;
            }
        }

        int previous = -1;
        int difference = right - left + 1;
        int[] pair = new int[] { -1, -1 };
        for (int i = left; i <= right; i++) {
            if (!isPrime[i]) {
                continue;
            }
            if (previous != -1) {
                int d = i - previous;
                if (d < difference) {
                    difference = d;
                    pair[0] = previous;
                    pair[1] = i;
                }
            }
            previous = i;
        }
        return pair;
    }
}
