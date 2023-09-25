class Solution {
    private static final int M = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        int n = 0;
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            } else {
                i = j;
            }
            n += j - i;
            n %= M;
        }
        return n % M;
    }

    public static void main(String[] args) {
        String s = "abbcccaa";

        Solution solution = new Solution();
        System.out.println(solution.countHomogenous(s));
        System.out.println(solution.countHomogenous("nnnnsssyyyyyyyyyyyyyyjjjjzzzzzz"));
    }
}
