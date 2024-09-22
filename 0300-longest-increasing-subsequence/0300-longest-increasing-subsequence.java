class Solution {
     public  int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];

        // Initialize the dp array with 1, as the minimum LIS at each element is 1 (the element itself)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill the dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // Check if we can extend the increasing subsequence
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum length in the dp array
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
