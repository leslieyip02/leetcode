class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        for (int num : nums) {
            Stack<Integer> tmp = new Stack<>();
            while (num > 0) {
                tmp.push(num % 10);
                num /= 10;
            }
            while (!tmp.empty()) {
                digits.add(tmp.pop());
            }
        }
        return digits.stream().mapToInt(Integer::intValue).toArray();
    }
}
