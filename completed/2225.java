import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer[]> winners = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (!winners.containsKey(winner)) {
                winners.put(winner, new Integer[] { 0, 0 });
            }
            if (!winners.containsKey(loser)) {
                winners.put(loser, new Integer[] { 0, 0 });
            }
            winners.get(winner)[0]++;
            winners.get(loser)[1]++;
        }
        List<List<Integer>> answer = new ArrayList();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer[]> entry : winners.entrySet()) {
            Integer key = entry.getKey();
            Integer[] values = entry.getValue();
            if (values[1] == 0 && values[0] != 0) {
                answer.get(0).add(key);
            } else if (values[1] == 1) {
                answer.get(1).add(key);
            }
        }
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        return answer;
    }
}
