class Solution {
    private static boolean isOperator(String token) {
        return token.compareTo("+") == 0
            || token.compareTo("-") == 0
            || token.compareTo("*") == 0
            || token.compareTo("/") == 0;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (Solution.isOperator(token)) {
                int b = nums.pop();
                int a = nums.pop();
                if (token.compareTo("+") == 0) {
                    nums.push(a + b);
                } else if (token.compareTo("-") == 0) {
                    nums.push(a - b);
                } else if (token.compareTo("*") == 0) {
                    nums.push(a * b);
                } else {
                    nums.push(a / b);
                }
            } else {
                nums.push(Integer.parseInt(token));
            }
        }
        return nums.pop();
    }
}
