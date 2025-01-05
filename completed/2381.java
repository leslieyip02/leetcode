import java.util.*;

class Solution {
    private char shiftLetter(char letter, int offset) {
        return (char) (((int) letter - 97 + 26 + offset) % 26 + 97);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int[] suffixSums = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int start = shift[0] + 1;
            int end = shift[1] + 1;
            int direction = shift[2];

            int offset = direction == 1 ? 1 : -1;
            suffixSums[end] += offset;
            suffixSums[start - 1] -= offset;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(shiftLetter(s.charAt(i), suffixSums[i + 1] % 26));
            suffixSums[i] += suffixSums[i + 1];
        }
        return sb.reverse().toString();
    }
}
