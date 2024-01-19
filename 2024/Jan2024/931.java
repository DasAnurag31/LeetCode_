class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int mini = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];

        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int j=0; j<matrix[0].length; j++){
            int ans = solve(0, j, matrix, dp);
            mini = Math.min(ans, mini);
        }
        return mini;
    }
    public int solve(int row, int col, int[][]matrix, int[][] dp){

        if(col<0 || col>=matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == matrix.length-1){
            return matrix[row][col];
        }
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }

        int case1 =  solve(row+1,col-1,matrix,dp);
        int case2 = solve(row+1,col,matrix,dp);
        int case3 =  solve(row+1,col+1,matrix,dp);
        
        return dp[row][col] = matrix[row][col] + Math.min(case1, Math.min(case2,case3));
    }
}