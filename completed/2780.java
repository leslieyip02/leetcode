class Solution {
    public int minimumIndex(List<Integer> nums) {
        int x = 0;
        int c = 0;
        for (int num : nums) {
            if (c == 0) {
                x = num;
                c = 1;
            } else {
                c += num == x ? 1 : -1;
            }
        }

        int total = 0;
        for (int num : nums) {
            if (num == x) {
                total++;
            }
        }

        int current = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == x) {
                current++;
            }

            int left = i + 1;
            int right = nums.size() - left;
            if (current > Math.floor(left / 2.0) && (total - current) > Math.floor(right / 2)) {
                return i;
            }
        }
        return -1;
    }
}
