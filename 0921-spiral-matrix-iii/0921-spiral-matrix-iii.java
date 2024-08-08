class Solution {
    private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
    private int d = 0; 

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public int[][] spiralMatrixIII(int rows, int cols, int x, int y) {
        int total = rows * cols;
        int[][] ans = new int[total][2];
        int i = 0;
        int steps = 0; 
        int limit = 1; 

        while (i < total) {
            for (int s = 0; s < limit; s++) {
                if (isValid(x, y, rows, cols)) {
                    ans[i][0] = x;
                    ans[i][1] = y;
                    i++;
                }
                x += direction[d][0];
                y += direction[d][1];
            }

            d = (d + 1) % 4;
            if (d % 2 == 0) {
                limit++;
            }
        }

        return ans;
    }
}
