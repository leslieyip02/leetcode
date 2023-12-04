class Solution {
    public String largestGoodInteger(String num) {
        int[] f = new int[num.length()];
        int largest = -1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                f[i] = f[i - 1] + 1;
                if (f[i] >= 2) {
                    largest = Math.max(Character.getNumericValue(num.charAt(i)), largest);
                }
            }
        }
        return largest == -1 ? "" : (largest + "").repeat(3);
    }

    public static void main(String[] args) {
        String num = "6777133339";

        Solution solution = new Solution();
        System.out.println(solution.largestGoodInteger(num));
    }
}
