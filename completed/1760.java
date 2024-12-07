import java.util.*;

class Solution {
    private boolean isPossible(int size, int[] nums, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            if (num > size) {
                operations += (int) Math.ceil((double) num / size) - 1;
                if (operations > maxOperations) {
                    return false;
                }
            }
        }
        return operations <= maxOperations;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = (int) 1e9;
        while (low < high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, nums, maxOperations)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
