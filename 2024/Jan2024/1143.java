class Solution {
    private int solve(String a, String b,int i,int j,int [][] dp){
        if(i >= a.length() || j >= b.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            return 1 + solve(a,b,i+1,j+1,dp);
        }
        int first = solve(a,b,i+1,j,dp);
        int second = solve(a,b,i,j+1,dp);
        int res = Math.max(first,second);
        return dp[i][j] = res;
        
    }
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        int dp[][] = new int[m+1][n+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return solve(a,b,0,0,dp);
    }
}