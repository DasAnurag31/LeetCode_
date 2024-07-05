class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        long count = 0;
        while(right < n){
            if(nums[right] == 0){
                count += right - left + 1;
            }
            else{
                left = right;
                left++;
            }
            right++;
        }
        return count;
    }
}