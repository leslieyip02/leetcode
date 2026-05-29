class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] aCounted = new boolean[n];
        boolean[] bCounted = new boolean[n];
        int[] prefixCommonArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefixCommonArray[i] = prefixCommonArray[i - 1];
            }
            aCounted[A[i] - 1] = true;
            bCounted[B[i] - 1] = true;
            if (A[i] == B[i]) {
                prefixCommonArray[i]++;
            } else {
                if (aCounted[A[i] - 1] && bCounted[A[i] - 1]) {
                    prefixCommonArray[i]++;
                }
                if (aCounted[B[i] - 1] && bCounted[B[i] - 1]) {
                    prefixCommonArray[i]++;
                }
            }
        }
        return prefixCommonArray;
    }
}
