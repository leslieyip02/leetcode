class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        if (num <= 10) {
            return (num - 1) + "";
        }

        // for numbers like 100, 1000, 10000, ...
        if (Math.log10(num) - ((int) Math.log10(num)) == 0) {
            return (num - 1) + "";
        }

        // for numbers like 101, 1001, 10001, ...
        if (Math.log10(num - 1) - ((int) Math.log10(num - 1)) == 0) {
            return (num - 2) + "";
        }

        // for numbers like 99, 999, 9999, ...
        if (Math.log10(num + 1) - ((int) Math.log10(num + 1)) == 0) {
            return (num + 2) + "";
        }

        int mid = n.length() / 2;
        String leftSubstring = n.substring(0, mid);
        String rightSubstring = n.substring(mid + n.length() % 2);
        String targetRightSubstring = new StringBuilder()
            .append(leftSubstring)
            .reverse()
            .toString();
        long left = Long.parseLong(leftSubstring);
        long right = Long.parseLong(rightSubstring);
        long targetRight = Long.parseLong(targetRightSubstring);

        int leadingZeros = 0;
        for (int i = mid - 1; i >= 0; i--) {
            if (n.charAt(i) != '0') {
                break;
            }
            leadingZeros++;
        }

        long decreaseDifference = right > targetRight
            ? right - targetRight
            : right - targetRight + (n.charAt(mid) == '0' || n.length() % 2 == 0
                ? (long) ((Math.pow(10, mid) + Math.pow(10, mid - 1)) / Math.pow(10, leadingZeros))
                : (long) Math.pow(10, mid));
        long increaseDifference = right < targetRight
            ? targetRight - right
            : targetRight - right + (n.charAt(mid) == '9' || n.length() % 2 == 0
                ? (long) Math.pow(10, mid) + (long) Math.pow(10, mid - 1)
                : (long) Math.pow(10, mid));

        return decreaseDifference <= increaseDifference
            ? num - decreaseDifference + ""
            : num + increaseDifference + "";
    }
}
