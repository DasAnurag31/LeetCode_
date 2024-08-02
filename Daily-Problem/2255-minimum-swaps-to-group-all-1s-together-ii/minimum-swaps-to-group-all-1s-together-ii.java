class Solution {
    public int minSwaps(int[] nums) {
        int windowSize = 0;
        int countOne = 0;
        int i = 0;
        int n = nums.length;
        int max = 0;
        for(int num:nums){
            windowSize += num == 1 ? 1 : 0;
        }
        while(i < 2 * n){
            while(i < windowSize){
                if(nums[i % n] == 1){
                    countOne += 1;
                }
                i++;
            }
            max = Math.max(max, countOne);
            if(nums[i % n] == 1){
                countOne += 1;
            }
            if(nums[(i - windowSize) % n] == 1){
                countOne -= 1;
            }
            max = Math.max(max, countOne);
            i++;
        }
        return Math.max(0, windowSize - max);
    }
}