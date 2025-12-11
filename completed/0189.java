class Solution {

    private void helper(int i, int[] nums, int k, boolean[] visited) {
        if (visited[i]) {
            return;
        }

        int tmp = nums[i];
        visited[i] = true;

        int next = (i + k) % nums.length;
        helper(next, nums, k, visited);
        nums[next] = tmp;
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            helper(i, nums, k, visited);
        }
    }
}
