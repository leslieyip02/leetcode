class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int steps = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int value = (int) s.charAt(i) - '0' + carry;
            if (value % 2 == 0) {
                carry = value / 2;
                steps++;
            } else {
                carry = 1;
                steps += 2;
            }
        }
        return steps + carry;
    }
}
