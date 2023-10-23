class Solution {
    public int findKthPositive(int[] arr, int k) {
        int previous = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != previous + 1) {
                if (k < arr[i] - previous) {
                    return previous + k;
                }
                k -= (arr[i] - previous - 1);
            }
            previous = arr[i];
        }
        return previous + k;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 3, 4, 7, 11 };
        // int k = 5;
        int[] arr = { 8, 17, 23, 34, 37, 42 };
        int k = 16;

        Solution solution = new Solution();
        System.out.println(solution.findKthPositive(arr, k));
    }
}
