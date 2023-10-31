class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        int current = arr[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i] ^ current;
            current ^= arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] pref = { 5, 2, 0, 3, 1 };

        Solution solution = new Solution();
        var result = solution.findArray(pref);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
