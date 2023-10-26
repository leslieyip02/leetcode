import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Long> dp = new HashMap<>();

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long total = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int k = arr[i] / arr[j];
                    if (dp.containsKey(k)) {
                        total += dp.get(arr[j]) * dp.get(k);
                        total %= Solution.M;
                    }
                }
            }
            dp.put(arr[i], total);
            sum += total;
            sum %= Solution.M;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 10 };

        Solution solution = new Solution();
        System.out.println(solution.numFactoredBinaryTrees(arr));
    }
}
