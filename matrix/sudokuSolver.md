# Valid Sudoko
## Algo:
* Check all Rows for any dublicate 
* Check all Cols for any dublicate
* Check all 9 Blocks

## Code:
```
class Solution {
    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Set<Character> set = null;

        // Check in All Rows
        for (int i = 0; i < rows; i++){
            set = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        // Check for All Cols
        for (int i = 0; i < cols; i++) {
            set = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                }

                set.add(board[j][i]);
            }
        }

        // Check in Block 
        for (int i = 0; i < rows; i = i + 3) {
            for (int j = 0; j < cols; j = j + 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }
}

```
