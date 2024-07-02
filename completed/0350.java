import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> p = new HashMap<>();
        for (int num : nums1) {
            p.put(num, p.getOrDefault(num, 0) + 1);
        }

        List<Integer> r = new ArrayList<>();
        for (int num : nums2) {
            if (p.containsKey(num)) {
                r.add(num);
                int c = p.get(num);
                if (c == 1) {
                    p.remove(num);
                } else {
                    p.put(num, c - 1);
                }
            }
        }

        int[] arr = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            arr[i] = r.get(i);
        }
        return arr;
    }
}
