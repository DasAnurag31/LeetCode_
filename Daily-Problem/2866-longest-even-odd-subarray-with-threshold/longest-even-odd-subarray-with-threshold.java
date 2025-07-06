class Solution {
    public int longestAlternatingSubarray(int[] nums, int k) {
        int max = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            


            while(left < nums.length && nums[left] % 2 != 0){
                left++;
            }
            if(right < left){
                right = left;
            }
            if(right == nums.length){
                break;
            }
            if((right - left) % 2 == 0){
                if(nums[right] % 2 != 0){
                    // shrink
                    left++;
                    continue;
                }
            }
            if((right - left) % 2 != 0){
                if(nums[right] % 2 == 0){
                    // shrink
                    left++;
                    continue;
                } 
            }
            if(nums[right] > k){
                left++;
            }
            else{
                System.out.println(left + " " + right);
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        return max;
    }
}