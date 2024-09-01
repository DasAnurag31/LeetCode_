class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int row = 0;
        int col = 0;
        int[][] ans = new int[m][n];
        if(m * n != original.length){
            return new int[0][0];
        }
        for(int i=0;i<original.length;i++){
            ans[row][col] = original[i];
            col++;
            if(col == n){
                row++;
                col = 0;
            }
        }
        return ans;
    }
}