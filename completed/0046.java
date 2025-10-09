class Solution {

    List<List<Integer>> permutations;

    public List<List<Integer>> permute(int[] nums) {
        permutations = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new Stack<>());
        return permutations;
    }

    void backtrack(int[] nums, boolean[] used, Stack<Integer> permutation) {
        boolean complete = true;
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }

            complete = false;
            permutation.push(nums[i]);
            used[i] = true;
            backtrack(nums, used, permutation);
            permutation.pop();
            used[i] = false;
        }

        if (complete) {
            permutations.add(new ArrayList<>(permutation));
        }
    }
}
