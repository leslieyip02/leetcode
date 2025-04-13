class Solution {
    private static final long M = (long) 1e9 + 7;

    public int countGoodNumbers(long n) {
        long m = n / 2;
        long base = 20;
        long count = n % 2 == 0 ? 1 : 5;
        while (m > 0) {
            if ((m & 1) == 1) {
                count = (count * base) % M;
            }
            base = (base * base) % M;
            m >>= 1;
        }
        return (int) count;
    }
}
