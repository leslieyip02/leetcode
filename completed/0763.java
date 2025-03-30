class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[(int) s.charAt(i) - 97]++;
        }

        Set<Character> current = new HashSet<>();
        List<Integer> sizes = new ArrayList<>();
        int previous = -1;
        for (int i = 0; i < s.length(); i++) {
            counts[(int) s.charAt(i) - 97]--;
            current.add(s.charAt(i));

            boolean canPartition = true;
            for (char c : current) {
                if (counts[(int) c - 97] != 0) {
                    canPartition = false;
                }
            }
            if (canPartition) {
                sizes.add(i - previous);
                previous = i;
                current.clear();
            }
        }
        return sizes;
    }
}
