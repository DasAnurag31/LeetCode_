## Code:
```
boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
boolean solveNQUtil(int board[][], int col)
    {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {  
                board[i][col] = 1;
                 if (solveNQUtil(board, col + 1) == true)
                    return true;
 
                board[i][col] = 0; // BACKTRACK
            }
        }
        return false;
    }
```
