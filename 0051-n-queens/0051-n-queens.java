import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        boolean[] colVisited = new boolean[n];
        
        backtrack(0, board, solutions, colVisited, n);
        
        return solutions;
    }
    
    private void backtrack(int row, char[][] board, List<List<String>> solutions, boolean[] colVisited, int n) {
        if (row == n) {
            solutions.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!colVisited[col] && isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                colVisited[col] = true;
                
                backtrack(row + 1, board, solutions, colVisited, n);
                
                board[row][col] = '.';
                colVisited[col] = false;
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, int n) { 
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }
}
