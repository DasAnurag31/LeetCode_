class Solution {
    public int fun(int[] arr, int sum, int i, int[][] dp) {
        if (i == 0) {
            if (sum % arr[i] == 0) {
                return sum / arr[i];
            }
            return Integer.MAX_VALUE-1;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int take = Integer.MAX_VALUE-1;
        if (arr[i] <= sum) {
            take = 1 + fun(arr, sum - arr[i], i,  dp);
        }
        int notTake = fun(arr, sum, i - 1,  dp);
        return dp[i][sum] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = fun(coins, amount, coins.length - 1, dp);
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }
}