class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n < 5){
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = n-3;
        while(right != n+1){
            min = Math.min(min, Math.abs(nums[left+1]-nums[right-1]));
            left++;
            right++;
        }
        return min;
    }
}