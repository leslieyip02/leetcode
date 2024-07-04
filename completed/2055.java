class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] plates = new int[s.length()];
        int[] leftNearest = new int[s.length()];
        int[] rightNearest = new int[s.length()];
        int nearest = -1;
        for (int i = 0; i < s.length(); i++) {
            int plate = s.charAt(i) == '*' ? 1 : 0;
            plates[i] = (i == 0 ? 0 : plates[i - 1]) + plate;

            if (plate == 0) {
                nearest = i;
            }
            rightNearest[i] = nearest;
        }
        nearest = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                nearest = i;
            }
            leftNearest[i] = nearest;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = leftNearest[queries[i][0]];
            int right = rightNearest[queries[i][1]];
            if (left == -1 || right == -1 || left >= right) {
                continue;
            }

            answer[i] = plates[right] - plates[left];
        }
        return answer;
    }
}
