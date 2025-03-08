class Solution {
    private static final int FLIP = 2;

    public int longestOnes(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int longest = 0;
        int flipped = 0;
        for (int num : nums) {
            if (num == 1) {
                q.add(1);
            } else {
                while (flipped == k && !q.isEmpty()) {
                    if (q.poll() == FLIP) {
                        flipped--;
                        break;
                    }
                }
                if (flipped < k) {
                    q.add(FLIP);
                    flipped++;
                }
            }
            longest = Math.max(q.size(), longest);
        }
        return longest;
    }
}
