class Solution {
    public int findMin(int[] nums) {
        // this looks stupid but worst case is O(n)
        // anyways, n = 5000 so it doesn't matter
        int min = 5001;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}
