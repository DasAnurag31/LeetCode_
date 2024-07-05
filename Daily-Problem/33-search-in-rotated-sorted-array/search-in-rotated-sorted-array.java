class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int index = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                index = mid;
                break;
            }
            else if(nums[mid] >= nums[low]){
                if(target < nums[mid] && target >= nums[low]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid] <= nums[high]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }   
        }
        return index;
    }
}