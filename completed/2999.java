class Solution {
    private long powerful(String s, long max, int limit) {
        String t = max + "";
        int prefixLength = t.length() - s.length();
        if (prefixLength < 0) {
            return 0;
        } else if (prefixLength == 0) {
            return t.compareTo(s) >= 0 ? 1 : 0;
        }

        long count = 0;
        for (int i = 0; i < prefixLength; i++) {
            int digit = t.charAt(i) - 48;
            if (digit > limit) {
                count += (long) Math.pow(limit + 1, prefixLength - i);
                return count;
            } else {
                count += (long) digit * Math.pow(limit + 1, prefixLength - 1 - i);
            }
        }
        if (t.substring(prefixLength).compareTo(s) >= 0) {
            count++;
        }
        return count;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return powerful(s, finish, limit) - powerful(s, start - 1, limit);
    }
}
