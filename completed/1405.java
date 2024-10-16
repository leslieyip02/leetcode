import java.util.*;

class Solution {
    class Letter {
        char value;
        int quantity;

        public Letter(char value, int quantity) {
            this.value = value;
            this.quantity = quantity;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Letter> pq = new PriorityQueue<>((x, y) -> y.quantity - x.quantity);
        if (a > 0) {
            pq.add(new Letter('a', a));
        }
        if (b > 0) {
            pq.add(new Letter('b', b));
        }
        if (c > 0) {
            pq.add(new Letter('c', c));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Letter current = pq.poll();
            if (sb.length() >= 2 &&
                sb.charAt(sb.length() - 1) == current.value &&
                sb.charAt(sb.length() - 2) == current.value) {

                // check next
                if (pq.isEmpty()) {
                    break;
                }

                Letter next = pq.poll();
                sb.append(next.value);
                next.quantity--;
                if (next.quantity > 0) {
                    pq.add(next);
                }
                pq.add(current);
            } else {
                sb.append(current.value);
                current.quantity--;
                if (current.quantity > 0) {
                    pq.add(current);
                }
            }
        }
        return sb.toString();
    }
}
