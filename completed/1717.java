import java.util.*;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> letters = new Stack<>();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c != 'a' && c != 'b') || letters.empty()) {
                letters.push(c);
                continue;
            }

            if (x > y) {
                if (letters.peek() == 'a' && c == 'b') {
                    letters.pop();
                    total += x;
                } else {
                    letters.push(c);
                }
            } else {
                if (letters.peek() == 'b' && c == 'a') {
                    letters.pop();
                    total += y;
                } else {
                    letters.push(c);
                }
            }
        }

        Stack<Character> previous = new Stack<>();
        while (!letters.empty()) {
            char c = letters.pop();
            if ((c != 'a' && c != 'b') || previous.empty()) {
                previous.push(c);
                continue;
            }

            if (x > y) {
                if (previous.peek() == 'a' && c == 'b') {
                    previous.pop();
                    total += y;
                } else {
                    previous.push(c);
                } 
            } else {
                if (previous.peek() == 'b' && c == 'a') {
                    previous.pop();
                    total += x;
                } else {
                    previous.push(c);
                }
            }
        }

        return total;
    }
}
