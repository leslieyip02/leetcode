class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int top = -1;
            while (!stack.empty()) {
                int tmp = stack.pop();
                if (temperatures[i] < temperatures[tmp]) {
                    top = tmp;
                    break;
                }
            }

            if (top != -1) {
                answer[i] = top - i;
                stack.push(top);
            }
            stack.push(i);
        }
        return answer;
    }
}
