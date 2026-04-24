import java.util.*;

class Solution {
    public boolean canTransform(String start, String result) {
        // 1st pass check Rs
        int startRs = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                startRs++;
            }
            if (result.charAt(i) == 'R') {
                if (startRs == 0) {
                    // there are no Rs that can be shifted right
                    return false;
                }
                startRs--;
            }
            if (start.charAt(i) == 'L' || result.charAt(i) == 'L') {
                if (startRs !=  0) {
                    // there are excess Rs that cannot be moved anymore
                    return false;
                }
            }
        }
        if (startRs != 0) {
            return false;
        }

        // 2nd pass check Ls
        int startLs = 0;
        for (int i = start.length() - 1; i >= 0; i--) {
            if (start.charAt(i) == 'L') {
                startLs++;
            }
            if (result.charAt(i) == 'L') {
                if (startLs == 0) {
                    return false;
                }
                startLs--;
            }
            if (start.charAt(i) == 'R' || result.charAt(i) == 'R') {
                if (startLs != 0) {
                    return false;
                }
            }
        }
        if (startLs != 0) {
            return false;
        }

        return true;
    }
}
