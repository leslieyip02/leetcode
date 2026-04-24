class Solution {
    private List<List<Integer>> combineHelper(int left, int right, int k) {
        if (k == 0) {
            return new ArrayList<>(List.of(new ArrayList<>()));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<List<Integer>> subLists = combineHelper(i + 1, right, k - 1);
            for (List<Integer> subList : subLists) {
                List<Integer> newSubList = new ArrayList<>(subList);
                newSubList.add(i);
                result.add(newSubList);
            }
        }
        return result;
    }

    public List<List<Integer>> combine(int n, int k) {
        // We can solve this recursively
        // To all the results from combine(n, k - 1), add another number that hasn't been used
        return combineHelper(1, n, k);
    }
}
