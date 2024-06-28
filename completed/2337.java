import java.util.*;

class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        char[] positions = start.toCharArray();

        for (int i = 0; i < n; i++) {
            if (positions[i] == target.charAt(i)) {
                continue;
            }

            if (target.charAt(i) == '_') {
                if (positions[i] == 'L') {
                    // cannot go left since everything on the left is correct
                    return false;
                } else {
                    // shift everything right to make space
                    int j = i;
                    boolean canShift = false;
                    for (; j < n - 1; j++) {
                        if (positions[j] == 'R' && positions[j + 1] == '_') {
                            canShift = true;
                            break;
                        }
                    }

                    if (!canShift) {
                        return false;
                    } else {
                        for (int k = j + 1; k > i; k--) {
                            positions[k] = positions[k - 1];
                        }
                        positions[i] = '_';
                    }
                }
            } else if (target.charAt(i) == 'L') {
                if (positions[i] == 'R') {
                    // cannot move an L into this position
                    return false;
                } else {
                    int j = i + 1;
                    boolean foundL = false;
                    for (; j < n; j++) {
                        if (positions[j] == 'L') {
                            foundL = true;
                            break;
                        } else if (positions[j] == 'R') {
                            return false;
                        }
                    }
                    if (!foundL) {
                        return false;
                    } else {
                        positions[i] = 'L';
                        positions[j] = '_';
                    }
                }
            } else {
                // not possible to get a R from the left
                return false;
            }
        }
        return true;
    }
}
