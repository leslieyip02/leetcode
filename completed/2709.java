import java.util.*;

class Solution {
    HashMap<Integer, HashSet<Integer>> primeToIndex = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> indexToPrime = new HashMap<>();

    boolean[] visitedIndex;
    HashSet<Integer> visitedPrime;

    void dfs(int index) {
        if (visitedIndex[index]) {
            return;
        }
        visitedIndex[index] = true;

        for (int prime : indexToPrime.get(index)) {
            if (visitedPrime.contains(prime)) {
                continue;
            }
            visitedPrime.add(prime);

            for (int adjacent : primeToIndex.get(prime)) {
                if (visitedIndex[adjacent]) {
                    continue;
                }
                dfs(adjacent);
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                return false;
            }

            for (int prime = 2; prime * prime <= nums[i]; prime++) {
                if (num % prime == 0) {
                    if (!primeToIndex.containsKey(prime)) {
                        primeToIndex.put(prime, new HashSet<>());
                    }
                    primeToIndex.get(prime).add(i);
                    if (!indexToPrime.containsKey(i)) {
                        indexToPrime.put(i, new HashSet<>());
                    }
                    indexToPrime.get(i).add(prime);
                    while (num % prime == 0) {
                        num /= prime;
                    }
                }
            }
            if (num != 1) {
                if (!primeToIndex.containsKey(num)) {
                    primeToIndex.put(num, new HashSet<>());
                }
                primeToIndex.get(num).add(i);
                if (!indexToPrime.containsKey(i)) {
                    indexToPrime.put(i, new HashSet<>());
                }
                indexToPrime.get(i).add(num);
            }
        }

        visitedIndex = new boolean[nums.length];
        visitedPrime = new HashSet<>();
        dfs(0);
        for (int i = 0; i < nums.length; i++) {
            if (!visitedIndex[i]) {
                return false;
            }
        }
        return true;
    }
}
