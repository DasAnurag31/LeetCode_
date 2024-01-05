class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, n, dp);
    }
    
    private int f(int ind, int prevInd, int[] nums, int n, int[][] dp) {
        if (ind == n) {
            return 0;
        }
        if (dp[ind][prevInd + 1] != -1) {
            return dp[ind][prevInd + 1];
        }

        // don't want to take
        int notTake = 0 + f(ind + 1, prevInd, nums, n, dp);
        
        // Let's take 
        int take = 0;
        if (prevInd == -1 || nums[prevInd] < nums[ind]) {
            take = 1 + f(ind + 1, ind, nums, n, dp);
        }
        
        return dp[ind][prevInd + 1] = Math.max(take, notTake);
    }
}