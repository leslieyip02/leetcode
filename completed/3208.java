class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        boolean[] visited = new boolean[colors.length];
        while (!visited[left]) {
            if ((right - left + colors.length) % colors.length < k - 1) {
                int current = colors[right];
                right = (right + 1) % colors.length;
                if (colors[right] == current) {
                    visited[left] = true;
                    left = right;
                }
            } else {
                count++;
                visited[left] = true;
                left = (left + 1) % colors.length;
            }
        }
        return count;
    }
}
