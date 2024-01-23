import java.util.*;

class Solution {
    private int toBitMask(String str) {
        int mask = 0;
        for (int i = 0; i < str.length(); i++) {
            int ascii = (int) str.charAt(i) - 97;
            int shifted = 1 << ascii;
            if ((mask & shifted) != 0) {
                return -1;
            }
            mask |= shifted;
        }
        return mask;
    }

    private int choose(int currentUsed, int currentIndex, List<String> arr) {
        if (currentIndex >= arr.size()) {
            return 0;
        }

        int max = this.choose(currentUsed, currentIndex + 1, arr);
        int mask = this.toBitMask(arr.get(currentIndex));
        if (mask != -1 && (mask & currentUsed) == 0) {
            int length = this.choose((currentUsed | mask), currentIndex + 1, arr) + arr.get(currentIndex).length();
            max = Math.max(length, max);
        }
        return max;
    }

    public int maxLength(List<String> arr) {
        return this.choose(0, 0, arr);
    }
}
