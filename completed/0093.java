class Solution {
    private boolean isChunkValid(String s, int left, int right) {
        int sum = 0;
        for (int i = left; i < right; i++) {
            if (i >= s.length()) {
                return false;
            }
            int digit = s.charAt(i) - '0';

            // Check for leading zeros
            if (digit == 0 && i == left && right - left != 1) {
                return false;
            }

            sum += digit * Math.pow(10, right - i - 1);
        }
        return sum <= 255;
    }

    private void partition(
        int index,
        String s,
        List<String> chunks,
        List<String> results
    ) {
        if (chunks.size() == 4) {
            if (index == s.length()) {
                results.add(String.join(".", chunks));
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!isChunkValid(s, index, index + i + 1)) {
                continue;
            }

            // Backtrack
            chunks.add(s.substring(index, index + i + 1));
            partition(index + i + 1, s, chunks, results);
            chunks.remove(chunks.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        // 1. Parition s into chunks (up to length 3)
        // 2. Check that the chunk is valid
        List<String> result = new ArrayList<>();
        partition(0, s, new ArrayList<>(), result);
        return result;
    }
}
