import java.util.*;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // this sucks
        int smallestIndex, secondSmallestIndex, biggestIndex, secondBiggestIndex;
        if (arrays.get(0).get(0) < arrays.get(1).get(0)) {
            smallestIndex = 0;
            secondSmallestIndex = 1;
        } else {
            smallestIndex = 1;
            secondSmallestIndex = 0;
        }
        if (arrays.get(0).get(arrays.get(0).size() - 1) > arrays.get(1).get(arrays.get(1).size() - 1)) {
            biggestIndex = 0;
            secondBiggestIndex = 1;
        } else {
            biggestIndex = 1;
            secondBiggestIndex = 0;
        }

        for (int i = 2; i < arrays.size(); i++) {
            int first = arrays.get(i).get(0);
            if (first < arrays.get(smallestIndex).get(0)) {
                secondSmallestIndex = smallestIndex;
                smallestIndex = i;
            } else if (first < arrays.get(secondSmallestIndex).get(0)) {
                secondSmallestIndex = i;
            }

            int last = arrays.get(i).get(arrays.get(i).size() - 1);
            if (last > arrays.get(biggestIndex).get(arrays.get(biggestIndex).size() - 1)) {
                secondBiggestIndex = biggestIndex;
                biggestIndex = i;
            } else if (last > arrays.get(secondBiggestIndex).get(arrays.get(secondBiggestIndex).size() - 1)) {
                secondBiggestIndex = i;
            }
        }

        if (smallestIndex != biggestIndex) {
            int first = arrays.get(smallestIndex).get(0);
            int last = arrays.get(biggestIndex).get(arrays.get(biggestIndex).size() - 1);
            return last - first;
        } else {
            int first = arrays.get(smallestIndex).get(0);
            int last = arrays.get(secondBiggestIndex).get(arrays.get(secondBiggestIndex).size() - 1);
            int diff = last - first;

            first = arrays.get(secondSmallestIndex).get(0);
            last = arrays.get(biggestIndex).get(arrays.get(biggestIndex).size() - 1);
            diff = Math.max(last - first, diff);
            return diff;
        }
    }
}
