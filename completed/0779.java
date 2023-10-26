class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int previous = kthGrammar(n - 1, (int) Math.ceil(k / 2.0));
        return previous == 0
            ? (k % 2 == 1 ? 0 : 1)
            : (k % 2 == 1 ? 1 : 0);
    }

    public static void main(String[] args) {
        int n = 1;
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.kthGrammar(n, k));
        System.out.println(solution.kthGrammar(3, 1));
        System.out.println(solution.kthGrammar(3, 2));
        System.out.println(solution.kthGrammar(3, 3));
        System.out.println(solution.kthGrammar(3, 4));
    }
}
