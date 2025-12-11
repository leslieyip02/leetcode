class Solution {

    private int helper(int num1, int num2) {
        if (num1 < num2) {
            return helper(num2, num1);
        }
        return num2 == 0 ? 0 : 1 + helper(num1 - num2, num2);
    }

    public int countOperations(int num1, int num2) {
        return helper(num1, num2);
    }
}
