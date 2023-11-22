import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, Stack<Integer>> stacks = new HashMap<>();
        int n = 0;
        int m = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                Stack<Integer> stack = stacks.getOrDefault(sum, new Stack<>());
                stack.push(nums.get(i).get(j));
                stacks.put(sum, stack);
                n++;
                m = Math.max(sum, m);
            }
        }
        int[] flattened = new int[n];
        int i = 0;
        for (int j = 0; j <= m; j++) {
            if (stacks.containsKey(j)) {
                Stack<Integer> stack = stacks.get(j);
                while (!stack.empty()) {
                    flattened[i] = stack.pop();
                    i++;
                }
            }
        }
        return flattened;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(6, 7),
            Arrays.asList(8),
            Arrays.asList(9, 10, 11),
            Arrays.asList(12, 13, 14, 15, 16)
        );

        Solution solution = new Solution();
        var result = solution.findDiagonalOrder(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
