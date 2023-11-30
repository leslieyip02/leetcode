class Solution {
    public int minimumOneBitOperations(int n) {
        int operations = 0;
        int current = 1 << 31;
        // alternate between adding and subtracting
        // since a subsequent 1 bit means less operations to flip the current
        boolean add = true;
        while (current != 0) {
            if ((n & current) != 0) {
                operations += ((current << 1) - 1) * (add ? 1 : -1);
                add = !add;
            }
            current >>>= 1;
        }
        return operations;
    }

    public static void main(String[] args) {
        int n = 6;

        Solution solution = new Solution();
        System.out.println(solution.minimumOneBitOperations(n));
    }
}
