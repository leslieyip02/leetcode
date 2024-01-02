import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int rows = 0;
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);
            rows = Math.max(count, rows);
        }

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                matrix.get(i).add(num);
            }
        }
        return matrix;
    }
}
