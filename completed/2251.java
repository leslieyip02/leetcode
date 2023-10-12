import java.util.*;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] starts = new int[flowers.length];
        int[] ends = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] bloom = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            // binary search for start
            int left = 0;
            int right = flowers.length - 1;
            int started = (left + right) / 2;
            while (left <= right) {
                if (starts[started] == people[i]) {
                    while (started < flowers.length - 1 && starts[started + 1] == people[i]) {
                        started++;
                    }
                    break;
                } else if (starts[started] < people[i]) {
                    left = started + 1;
                } else {
                    right = started - 1;
                }
                started = (left + right) / 2;
            }
            if (starts[started] <= people[i]) {
                started++;
            }

            // binary search for end
            left = 0;
            right = flowers.length - 1;
            int ended = (left + right) / 2;
            while (left <= right) {
                if (ends[ended] == people[i]) {
                    while (ended > 0 && ends[ended - 1] == people[i]) {
                        ended--;
                    }
                    break;
                } else if (ends[ended] < people[i]) {
                    left = ended + 1;
                } else {
                    right = ended - 1;
                }
                ended = (left + right) / 2;
            }
            if (ends[ended] < people[i]) {
                ended++;
            }

            bloom[i] = Math.max(started - ended, 0);
        }
        return bloom;
    }

    public static void main(String[] args) {
        int[][] flowers = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
        int[] people = { 2, 3, 7, 11 };

        Solution solution = new Solution();
        var result = solution.fullBloomFlowers(flowers, people);
        for (int bloom : result) {
            System.out.println(bloom);
        }
    }
}
