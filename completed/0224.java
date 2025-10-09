class Solution {

    int left;

    public int calculate(String s) {
        left = 0;
        return calculateHelper(s);
    }

    int calculateHelper(String s) {
        int result = 0;
        int multiplier = 1;

        while (left < s.length()) {
            if (s.charAt(left) == ' ') {
                left++;
                continue;
            }

            if (s.charAt(left) == '+') {
                multiplier *= 1;
                left++;
                continue;
            }

            if (s.charAt(left) == '-') {
                multiplier *= -1;
                left++;
                continue;
            }

            if (Character.isDigit(s.charAt(left))) {
                int right = left + 1;
                while (right < s.length() && Character.isDigit(s.charAt(right))) {
                    right++;
                }

                String token = s.substring(left, right);
                result += Integer.parseInt(token) * multiplier;
                multiplier = 1;
                left = right;
                continue;
            }

            if (s.charAt(left) == '(') {
                left++;
                result += calculateHelper(s) * multiplier;
                multiplier = 1;
                continue;
            }

            if (s.charAt(left) == ')') {
                left++;
                return result;
            }
        }
        return result;
    }
}

