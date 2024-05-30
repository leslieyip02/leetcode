class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;

        // if the subarray total is 0,
        // then it can be partitioned into 2 equal halves
        int count = 0;

        // store XOR total of subarray from i to j
        int[][] subarrays = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(subarrays[i], -1);

            // first sequence of length 2
            subarrays[i][i + 1] = arr[i] ^ arr[i + 1];
            if (subarrays[i][i + 1] == 0) {
                count++;
            }
            for (int j = i + 2; j < n; j++) {
                subarrays[i][j] = subarrays[i][j - 1] ^ arr[j];
                if (subarrays[i][j] == 0) {
                    count += j - i;
                }
            }
        }
        return count;
    }
}
