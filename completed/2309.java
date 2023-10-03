class Solution {
    public String greatestLetter(String s) {
        boolean[][] letters = new boolean[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean upper = Character.isUpperCase(c);
            int ascii = (int) c - (upper ? 65 : 97);
            int index = upper ? 0 : 1;
            letters[ascii][index] = true;
        }
        for (int i = 25; i >= 0; i--) {
            if (letters[i][0] && letters[i][1]) {
                return new Character((char) (i + 65)).toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "arRAzFif";

        Solution solution = new Solution();
        System.out.println(solution.greatestLetter(s));
    }
}
