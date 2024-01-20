import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int[] subarraySums = new int[arr.length];
        Stack<Integer> mins = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!mins.empty() && arr[mins.peek()] >= arr[i]) {
                mins.pop();
            }

            if (mins.empty()) {
                // current is the smallest,
                // so all subarrays ending at i have min at i
                subarraySums[i] = arr[i] * (i + 1);
            } else {
                // add sum from previous
                int previous = mins.peek();
                subarraySums[i] = subarraySums[previous];
                subarraySums[i] += arr[i] * (i - previous);
            }
            mins.push(i);
            sum += subarraySums[i];
            sum %= Solution.M;
        }
        return sum;
    }
}
