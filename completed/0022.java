class Solution {
    private List<String> combinations;

    private void helper(int open, int close, Stack<String> current) {
        if (close == 0) {
            combinations.add(String.join("", current));
            return;
        }
        if (open < close) {
            current.push(")");
            helper(open, close - 1, current);
            current.pop();
        }
        if (open > 0) {
            current.add("(");
            helper(open - 1, close, current);
            current.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        combinations = new ArrayList<>();
        helper(n, n, new Stack<>());
        return combinations;
    }
}
