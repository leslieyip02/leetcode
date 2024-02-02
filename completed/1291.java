class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int min = (int) Math.log10(low) + 1;
        int max = (int) Math.log10(high) + 1;
        List<Integer> numbers = new ArrayList<>();
        for (int n = min; n <= max; n++) {
            int start = 1;
            while (start + n - 1 <= 9) {
                int number = 0;
                for (int i = 0; i < n; i++) {
                    number *= 10;
                    number += (start + i);
                }
                start++;
                if (number < low) {
                    continue;
                } else if (number > high) {
                    break;
                }
                numbers.add(number);
            }
        }
        return numbers;
    }
}
