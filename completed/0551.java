class Solution {
    public boolean checkRecord(String s) {
        boolean a = false;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                if (a) {
                    return false;
                }
                a = true;
                l = 0;
            } else if (s.charAt(i) == 'L') {
                l++;
                if (l >= 3) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }
}
