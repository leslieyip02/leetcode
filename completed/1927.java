class Solution {
    public boolean sumGame(String num) {
        int leftBlanks = 0;
        int leftSum = 0;
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) == '?') {
                leftBlanks++;
                continue;
            }
            leftSum += (int) num.charAt(i) - '0';
        }

        int rightBlanks = 0;
        int rightSum = 0;
        for (int i = num.length() / 2; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                rightBlanks++;
                continue;
            }
            rightSum += (int) num.charAt(i) - '0';
        }

        if ((leftBlanks + rightBlanks) % 2 == 1) {
            // Bob can't react
            return true;
        }

        // Bob can copy all of Alice's moves
        int blanksDifference = leftBlanks - rightBlanks;
        int sumDifference = leftSum - rightSum;

        // If the blanks are on the half with the greater sum, they can't help Bob win
        if ((double) blanksDifference / (double) sumDifference < 0) {
            return true;
        }

        // Bob can make any pair of blanks into a 9; Bob can win if the difference is modulo 9
        return Math.abs(sumDifference) != Math.abs(blanksDifference) / 2 * 9;
    }
}
