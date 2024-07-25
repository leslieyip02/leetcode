class Solution {
    public int longestMountain(int[] arr) {
        int[] increasing = new int[arr.length];
        int[] decreasing = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            increasing[i] = arr[i] > arr[i - 1] ? increasing[i - 1] + 1 : 0;
        }

        int longest = 0;
        for (int i = arr.length - 2; i > 0; i--) {
            decreasing[i] = arr[i] > arr[i + 1] ? decreasing[i + 1] + 1: 0;
            if (increasing[i] == 0 || decreasing[i] == 0) {
                continue;
            }

            int length = increasing[i] + 1 + decreasing[i];
            longest = Math.max(length, longest);
        }
        return longest;
    }
}
