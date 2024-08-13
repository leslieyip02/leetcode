import java.util.*;

class Solution {
    private void search(
        int[] candidates,
        int target,
        int currentIndex,
        List<Integer> currentList,
        List<List<Integer>> result
    ) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            if (i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            currentList.add(candidates[i]);
            search(candidates, target - candidates[i], i + 1, currentList, result); 
            currentList.remove(currentList.size() - 1);
        }
    } 

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}
