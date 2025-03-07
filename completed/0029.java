class Solution {
    private long helper(long dividend, long divisor, long current, int shift) {
        if (divisor > dividend) {
            return 0;
        }

        return (current << 1) > dividend
            ? (1L << shift) + helper(dividend - current, divisor, divisor, 0)
            : helper(dividend, divisor, current << 1, shift + 1);
    }

    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        int sign = 1;
        if (dividend < 0) {
            sign *= -1;
            x *= -1;
        }
        if (divisor < 0) {
            sign *= -1;
            y *= -1;
        }
        long result = helper(x, y, y, 0) * sign;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
