class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int target = k * threshold;
        int count = sum >= target ? 1 : 0;

        int left = 0;
        int right = k;
        while (right < arr.length) {
            sum -= arr[left];
            sum += arr[right];
            left++;
            right++;
            if (sum >= target) {
                count++;
            }
        }
        return count;
    }
}
