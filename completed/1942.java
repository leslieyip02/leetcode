import java.util.*;

class Solution {
    private class Friend {
        int index;
        int start;
        int end;
        int chair;

        public Friend(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        Friend[] friends = new Friend[times.length];
        for (int i = 0; i < times.length; i++) {
            friends[i] = new Friend(i, times[i][0], times[i][1]);
        }
        Arrays.sort(friends, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        int maxChair = 0;
        chairs.add(maxChair);
        PriorityQueue<Friend> occupied = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (Friend friend : friends) {
            while (!occupied.isEmpty() && occupied.peek().end <= friend.start) {
                Friend done = occupied.poll();
                chairs.add(done.chair);
            }

            if (chairs.isEmpty()) {
                maxChair++;
                chairs.add(maxChair);
            }
            friend.chair = chairs.poll();
            if (friend.index == targetFriend) {
                 return friend.chair;   
            }
            occupied.add(friend);
        }
        return -1;
    }
}
