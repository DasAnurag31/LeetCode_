class Solution {
    private int n;
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    private void reverse(int[] nums, int start){
        int end = n-1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        // Find the index
        n = nums.length;
        int index = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        System.out.println(index);
        if(index == -1){
            reverse(nums, 0);
            return;
        }
        // Reverse the right half of the index in the array
        reverse(nums, index+1);
        // swap the value at index with the first value to it's right
        for(int i=index+1;i<n;i++){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }
    }
}