import java.util.*

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> indices = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            indices.add(i);
        }

        int current = 0;
        int[] ordered = new int[deck.length];
        while (!indices.isEmpty()) {
            int index = indices.poll();
            ordered[index] = deck[current];
            current++;
            if (!indices.isEmpty()) {
                indices.add(indices.poll());
            }
        }
        return ordered;
    }
}
