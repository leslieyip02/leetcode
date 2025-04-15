class Solution {
    class FenwickTree {
        int[] values;

        FenwickTree(int n) {
            this.values = new int[n + 1];
        }

        void update(int index, int increment) {
            index++;
            while (index < values.length) {
                values[index] += increment;
                index += index & -index;
            }
        }

        long query(int index) {
            long total = 0;
            index++;
            while (index > 0) {
                total += values[index];
                index -= index & -index;
            }
            return total;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[nums1[i]] = i;
        }

        FenwickTree seen = new FenwickTree(n);

        long total = 0;
        for (int i = 0; i < n; i++) {
            int index = indices[nums2[i]];
            long left = seen.query(index);
            long right = n - 1 - index - (seen.query(n - 1) - left);
            total += left * right;
            seen.update(index, 1);
        }
        return total;
    }
}
