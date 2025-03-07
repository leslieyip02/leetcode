class Solution {
    private int helper(int[] shares, int[] cookies, int index, int unfairness) {
        if (index == cookies.length) {
            return Arrays.stream(shares).reduce(0, (a, b) -> Math.max(a, b));
        }

        for (int i = 0; i < shares.length; i++) {
            shares[i] += cookies[index];
            if (shares[i] < unfairness) {
                unfairness = Math.min(helper(shares, cookies, index + 1, unfairness), unfairness);
            }
            shares[i] -= cookies[index];
        }
        return unfairness;
    }

    public int distributeCookies(int[] cookies, int k) {
        return helper(new int[k], cookies, 0, (int) 1e6);
    }
}
