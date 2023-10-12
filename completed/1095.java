/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 1;
        int right = mountainArr.length() - 2;
        int peak = (left + right) / 2;
        while (left < right) {
            int prev = mountainArr.get(peak - 1);
            int curr = mountainArr.get(peak);
            int next = mountainArr.get(peak + 1);
            if (prev < curr && curr > next) {
                break;
            } else if (prev < curr && curr < next) {
                // we're on the left
                left = peak + 1;
            } else {
                // we're on the right
                right = peak - 1;
            }
            peak = (left + right) / 2;
        }

        // binary search left half
        left = 0;
        right = peak;
        int index = (left + right) / 2;
        while (left < right) {
            int value = mountainArr.get(index);
            if (value >= target) {
                right = index;
            } else {
                left = index + 1;
            }
            index = (left + right) / 2;
        }
        if (mountainArr.get(index) == target) {
            return index;
        }

        // binary search right half
        left = peak + 1;
        right = mountainArr.length() - 1;
        index = (left + right) / 2;
        while (left < right) {
            int value = mountainArr.get(index);
            if (value <= target) {
                right = index;
            } else {
                left = index + 1;
            }
            index = (left + right) / 2;
        }
        return mountainArr.get(index) == target ? index : -1;
    }
}
