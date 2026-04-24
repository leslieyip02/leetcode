class Solution {
    public int maxProduct(int[] nums) {
        int maximum = nums[0];

        // even if we run into a negative number, just keep going
        //
        // if the number of negative numbers is even,
        // they cancel out and so the final product is positive
        //
        // otherwise, if the number of negative numbers is odd,
        // we will need to check if the product from the left or right is greater
        // any “in between” negative numbers will cancel out

        // go left to right
        int current = 1;
        for (int i = 0; i < nums.length; i++) {
            current *= nums[i];
            maximum = Math.max(current, maximum);
            if (current == 0) {
                current = 1;
            }
        }

            // go right to left
            current = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                current *= nums[i];
                maximum = Math.max(current, maximum);
                if (current == 0) {
                    current = 1;
            }
        }

        return maximum;
    }
}

