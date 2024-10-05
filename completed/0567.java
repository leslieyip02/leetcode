import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] reference = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = (int) s1.charAt(i) - 'a';
            reference[index]++;
        }

        int[] current = new int[26];
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            int rightIndex = (int) s2.charAt(right) - 'a';
            if (reference[rightIndex] == 0) {
                Arrays.fill(current, 0);
                right++;
                left = right;
                continue;
            }

            current[rightIndex]++;
            while (left < right && current[rightIndex] > reference[rightIndex]) {
                int leftIndex = (int) s2.charAt(left) - 'a';
                current[leftIndex]--;
                left++;
            }

            boolean ok = true;
            for (int i = 0; i < reference.length; i++) {
                if (current[i] != reference[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
            right++;
        }
        return false;
    }
}
