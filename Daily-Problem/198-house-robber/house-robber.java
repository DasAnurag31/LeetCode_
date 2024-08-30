class Solution {
    private int rob(int[] nums, int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int take, skip;
        take = nums[n] + rob(nums, n-2, dp);;
        skip = rob(nums, n-1, dp);;
        return dp[n] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp =  new int[n+1];
        Arrays.fill(dp, -1);
        return rob(nums, n-1, dp);
    }
}