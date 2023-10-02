class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < colors.length(); i++) {
            int j = i + 1;
            while (j < colors.length() && colors.charAt(j) == colors.charAt(i)) {
                j++;
            }
            if (colors.charAt(i) == 'A') {
                a += Math.max(j - i - 2, 0);
            } else {
                b += Math.max(j - i - 2, 0);
            }
            i = j - 1;
        }
        return a > b;
    }

    public static void main(String[] args) {
        String colors = "AAABABB";

        Solution solution = new Solution();
        System.out.println(solution.winnerOfGame(colors));
        System.out.println(solution.winnerOfGame("AA"));
    }
}
