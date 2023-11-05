class Solution {
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length) {
            int winner = 0;
            for (int i : arr) {
                winner = Math.max(i, winner);
            }
            return winner;
        }

        for (int i = 0; i < arr.length; i++) {
            int wins = i == 0 ? 0 : 1;
            int j = 1;
            while (wins < k) {
                if (arr[(i + j) % arr.length] < arr[i]) {
                    wins++;
                    j++;
                } else {
                    break;
                }
            }
            if (wins == k) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 1, 3, 5, 4, 6, 7 };
        // int k = 2;
        // int[] arr = { 3, 2, 1 };
        // int k = 10;
        int[] arr = { 1, 11, 22, 33, 44, 55, 66, 77, 88, 99 };
        int k = 1000000000;

        Solution solution = new Solution();
        System.out.println(solution.getWinner(arr, k));
    }
}
