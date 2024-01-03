class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank[0].length();
        int total = 0;
        int previousRow = 0;
        for (String row : bank) {
            int devices = 0;
            for (int i = 0; i < n; i++) {
                if (row.charAt(i) == '1') {
                    devices++;
                }
            }
            if (devices > 0) {
                total += previousRow * devices;
                previousRow = devices;
            }
        }
        return total;
    }
}
