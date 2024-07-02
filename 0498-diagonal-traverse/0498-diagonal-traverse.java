class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[] result = new int[row*column];

        int i = 0, j = 0, index = 0;
        boolean up = true;
        while(i < row && j < column){
            if(up){
                while(i >= 0 & j < column) {
                    result[index++] = mat[i][j];
                    i--;
                    j++;
                }
                i++;
                if(j == column) {i++; j--;}
                up = false;
            } else {
                while(j >= 0 & i < row){
                    result[index++] = mat[i][j];
                    i++;
                    j--;
                }
                j++;
                if(i == row) {i--; j++;}
                up = true;
            }
        }
        return result;
    }
}