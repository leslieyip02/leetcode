class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = i + "";
            if (s.length() % 2 == 1) {
                continue;
            }

            String a = s.substring(0, s.length() / 2);
            String b = s.substring(s.length() / 2);
            int c = 0;
            int d = 0;
            for (int j = 0; j < a.length(); j++) {
                c += a.charAt(j) - 48;
                d += b.charAt(j) - 48;
            }
            if (c == d) {
                count++;
            }
        }
        return count;
    }
}
