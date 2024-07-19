class Solution {
    private boolean checkMax(int[][] matrix, int col, int val){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col] > val){
                return false;
            }
        }
        return true;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        for(int[] row: matrix){
            int minValue = Integer.MAX_VALUE;
            int minIndexCol = -1;

            for(int i=0;i<cols;i++){
                if(row[i] < minValue){
                    minValue = row[i];
                    minIndexCol = i;
                }
            }

            if(checkMax(matrix, minIndexCol, minValue)){
                ans.add(minValue);
            }
        }

        return ans;
    }
}