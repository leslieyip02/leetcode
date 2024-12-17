import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++) {
            f[(int) s.charAt(i) - 97]++;
        }

        PriorityQueue<Character> letters = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) {
                letters.add((char) (i + 97));
            }
        }

        StringBuilder sb = new StringBuilder();
        char last = '!';
        int lastCount = 0;
        while (!letters.isEmpty()) {
            char current = letters.poll();
            if (current == last) {
                if (lastCount == repeatLimit) {
                    if (letters.isEmpty()) {
                        break;
                    }

                    char next = letters.poll();
                    sb.append(next);
                    f[(int) next - 97]--;
                    if (f[(int) next - 97] != 0) {
                        letters.add(next);
                    }
                    last = next;
                    lastCount = 1;
                    letters.add(current);
                } else {
                    sb.append(current);
                    f[(int) current - 97]--;
                    if (f[(int) current - 97] != 0) {
                        letters.add(current);
                    }
                    lastCount++;
                }
            } else {
                sb.append(current);
                f[(int) current - 97]--;
                if (f[(int) current - 97] != 0) {
                    letters.add(current);
                }
                last = current;
                lastCount = 1;
            }
        }
        return sb.toString();
    }
}
