class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            // store sum of values in column from j to i
            int[] colSums = new int[n];
            for (int j = i; j >= 0; j--) {
                for (int k = 0; k < n; k++) {
                    colSums[k] += matrix[j][k];
                }

                // accumulate sums across columns
                int current = 0;
                HashMap<Integer, Integer> memo = new HashMap<>();
                for (int sum : colSums) {
                    current += sum;
                    if (current == target) {
                        count++;
                    }
                    if (memo.containsKey(current - target)){
                        count += memo.get(current - target);
                    }
                    memo.put(current, memo.getOrDefault(current, 0) + 1);
                }
            }
        }
        return count;
    }
}
