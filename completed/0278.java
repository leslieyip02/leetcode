/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
public class VersionControl {
    private final int bad = 1702766719;

    protected boolean isBadVersion(int n) {
        return n >= bad;
    }
}
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int index = (int) (((long) left + right) / 2);
        while (left < right) {
            if (this.isBadVersion(index)) {
                right = index;
            } else {
                left = index + 1;
            }
            index = (int) (((long) left + right) / 2);
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 2126753390;

        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(n));
    }
}
