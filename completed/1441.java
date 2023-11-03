import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();

        int current = 0;
        for (int i = 1; i <= n && current < target.length; i++) {
            operations.add("Push");
            if (i == target[current]) {
                current++;
            } else {
                operations.add("Pop");
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        // int[] target = { 1, 3 };
        // int n = 3;
        int[] target = { 1, 2 };
        int n = 4;

        Solution solution = new Solution();
        System.out.println(solution.buildArray(target, n));
    }
}
