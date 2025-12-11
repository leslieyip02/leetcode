class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> previous = new Stack<>();
        previous.push(0);

        int operations = 0;
        for (int num : nums) {
            while (num < previous.peek()) {
                previous.pop();
                operations++;
            }

            if (num != previous.peek()) {
                previous.push(num);
            }
        }

        while (!previous.empty()) {
            if (previous.peek() == 0) {
                break;
            }

            previous.pop();
            operations++;
        }

        return operations;
    }
}
