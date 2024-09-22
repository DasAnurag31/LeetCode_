class Solution {
     public int fun(int[] arr, int sum, int i, int[][] dp) {
        if (i == 0) {
            if (sum % arr[i] == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int take = 0;
        if (arr[i] <= sum) {
            take =  fun(arr, sum - arr[i], i,  dp);
        }
        int notTake = fun(arr, sum, i - 1,  dp);
        return dp[i][sum] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = fun(coins, amount, coins.length - 1, dp);
        return ans;
    }
}