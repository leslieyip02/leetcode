class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i > -1; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "35427";

        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber(num));
    }
}
