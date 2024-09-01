import java.util.*;

class Solution {
    private int compare(String a, String b) {
        return a.length() == b.length()
            ? a.compareTo(b)
            : a.length() - b.length();
    }

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> compare(a, b));
        for (String num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
