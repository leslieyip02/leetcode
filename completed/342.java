class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 16;

        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(n));
    }
}
