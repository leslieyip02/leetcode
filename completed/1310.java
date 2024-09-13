class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixes = new int[arr.length];
        prefixes[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixes[i] = arr[i] ^ prefixes[i - 1];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] == 0 ? 0 : prefixes[queries[i][0] - 1];
            int right = prefixes[queries[i][1]];
            answer[i] = left ^ right;
        }
        return answer;
    }
}
