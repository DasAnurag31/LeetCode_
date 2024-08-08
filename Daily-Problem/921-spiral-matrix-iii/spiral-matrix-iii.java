class Solution {
    private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int[][] spiralMatrixIII(int rows, int cols, int x, int y) {
        int total = rows * cols;
        int[][] ans = new int[total][2];
        int i = 0;

        int d = 0; 

        int left = y - 1;
        int right = y + 1;
        int up = x - 1;
        int down = x + 1;

        while (i < total) {
            if (isValid(x, y, rows, cols)) {
                ans[i][0] = x;
                ans[i][1] = y;
                i++;
            }

            x += direction[d][0];
            y += direction[d][1];

            if (x < up || x > down || y < left || y > right) {
                x -= direction[d][0];
                y -= direction[d][1];

                if (d == 0) { 
                    right++;
                } else if (d == 1) { 
                    down++;
                } else if (d == 2) { 
                    left--;
                } else if (d == 3) { 
                    up--;
                }

                d = (d + 1) % 4;

                x += direction[d][0];
                y += direction[d][1];
            }
        }

        return ans;
    }
}
