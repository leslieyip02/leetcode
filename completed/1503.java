class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int longest = 0;
        for (int i : left) {
            longest = Math.max(i, longest);
        }
        for (int i : right) {
            longest = Math.max(n - i, longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] left = { 4, 3 };
        int[] right = { 0, 1 };

        Solution solution = new Solution();
        System.out.println(solution.getLastMoment(n, left, right));
    }
}
