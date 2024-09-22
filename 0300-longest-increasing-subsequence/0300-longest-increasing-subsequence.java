class Solution {
     
    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        // dp[i] will hold the length of the longest increasing subsequence that ends with arr[i]
        int[] dp = new int[n];

        // Initialize the dp array, each element is at least a subsequence of length 1 (itself)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLength = 1; // Initialize maxLength to 1 since at least one element exists

        // Fill the dp array and calculate maxLength at the same time
        for (int i = 1; i < n; i++) {
            for (int prev_index = 0; prev_index < i; prev_index++) {
                if (arr[prev_index] < arr[i] && dp[prev_index] + 1 > dp[i]) {
                    dp[i] = dp[prev_index] + 1;
                }
            }
            // Update maxLength during the DP computation
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
