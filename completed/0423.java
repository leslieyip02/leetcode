import java.util.*;

class Solution {
    private void updateCounts(String digit, int[] counts) {
        for (int i = 0; i < digit.length(); i++) {
            counts[(int) digit.charAt(i) - 97]--;
        }
    }

    public String originalDigits(String s) {
        // zero
        // one
        // two
        // three
        // four
        // five
        // six
        // seven
        // eight
        // nine
        int[] ok = new int[10];
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'z':
                    ok[0]++;
                    updateCounts("zero", counts);
                    break;
                case 'w':
                    ok[2]++;
                    updateCounts("two", counts);
                    break;
                case 'u':
                    ok[4]++;
                    updateCounts("four", counts);
                    break;
                case 'x':
                    ok[6]++;
                    updateCounts("six", counts);
                    break;
                case 'g':
                    ok[8]++;
                    updateCounts("eight", counts);
                    break;
                default:
                    break;
            }
            counts[(int) c - 97]++;
        }

        while (counts[(int) 'f' - 97] != 0) {
            ok[5]++;
            updateCounts("five", counts);
        }

        ok[1] = counts[(int) 'o' - 97];
        ok[3] = counts[(int) 'r' - 97];
        ok[7] = counts[(int) 'v' - 97];
        ok[9] = counts[(int) 'i' - 97];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < ok[i]; j++) {
                sb.append((char) (i + 48));
            }
        }
        return sb.toString();
    }
}
