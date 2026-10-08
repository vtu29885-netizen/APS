class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int[] result = new int[n];
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            // Elements to the right sum
            int rightSum = totalSum - leftSum - nums[i];

            // For left side: nums[i] is greater than or equal to all elements
            int leftDiff = i * nums[i] - leftSum;

            // For right side: all elements are greater than or equal to nums[i]
            int rightDiff = rightSum - (n - 1 - i) * nums[i];

            result[i] = leftDiff + rightDiff;

            leftSum += nums[i];
        }

        return result;
    }
}