class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                c++;
            }
            n >>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = -3;

        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(n));
    }
}
