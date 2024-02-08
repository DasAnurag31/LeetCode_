class Solution {
    private int recursion(int n, int[] dp){
        int root = (int) Math.floor(Math.sqrt(n));
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(root * root == n){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int count = Integer.MAX_VALUE;
        for(int i = root;i >= 1;i--){
            int square = i * i;
            count = Math.min(count,1 + recursion(n - square, dp));
        }
        return dp[n] = count;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int root = (int)Math.sqrt(n);
        if(root * root == n){
            return 1;
        }
        return recursion(n,dp);
    }
}