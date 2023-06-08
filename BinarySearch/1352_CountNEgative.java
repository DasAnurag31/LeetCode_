// Count the No of Negative nums in a matrix in O(m+n) time instead of O(MxN) time
class Solution {
    private int Bs(int left,int right,int[] arr){
        while(left <= right){
            int mid = left + (right -left)/2;
            if(arr[mid] < 0){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return arr.length - left;
    }
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int count = 0;
        for(int row[] : grid){
            count += Bs(0,n-1,row);
        }
        return count;
    }
}
