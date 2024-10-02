import java.util.*;

class Solution {
    private class Entry {
        public int value;
        public int index;
        public int rank;

        public Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        Entry[] entries = new Entry[arr.length];
        for (int i = 0; i < arr.length; i++) {
            entries[i] = new Entry(arr[i], i);
        }
        Arrays.sort(entries, (a, b) -> a.value - b.value);

        int rank = 1;
        int index = 0;
        while (index < arr.length) {
            entries[index].rank = rank;
            if (index + 1 < arr.length && entries[index + 1].value > entries[index].value) {
                rank++;
            }
            index++;
        }
        Arrays.sort(entries, (a, b) -> a.index - b.index);

        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = entries[i].rank;
        }
        return answer;
    }
}
