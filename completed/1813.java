import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();
        for (String w : sentence1.split(" ")) {
            d1.addLast(w);
        }
        for (String w : sentence2.split(" ")) {
            d2.addLast(w);
        }

        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekFirst().compareTo(d2.peekFirst()) == 0) {
            d1.pollFirst();
            d2.pollFirst();
        }
        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().compareTo(d2.peekLast()) == 0) {
            d1.pollLast();
            d2.pollLast();
        }
        return d1.isEmpty() || d2.isEmpty();
    }
}
