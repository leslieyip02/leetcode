class Solution {
    public int largestCombination(int[] candidates) {
        int maxCandidate = (int) 1e7;
        int current = 1;
        int largest = 1;
        while (current < maxCandidate) {
            int count = 0;
            for (int candidate : candidates) {
                if ((candidate & current) >= 1) {
                    count++;
                }
            }
            largest = Math.max(count, largest);
            current <<= 1;
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] candidates = { 16, 17, 71, 62, 12, 24, 14 };

        Solution solution = new Solution();
        System.out.println(solution.largestCombination(candidates));
    }
}
