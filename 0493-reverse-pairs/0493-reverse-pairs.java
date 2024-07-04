import java.util.*;

class Solution {
    private int mergeSortAndCount(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int count = 0;
        count += mergeSortAndCount(nums, low, mid);
        count += mergeSortAndCount(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }
    
    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        
        while (left <= mid && right <= high) {
            if ((long) nums[left] > 2 * (long) nums[right]) {
                count += (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }
        
        List<Integer> sorted = new ArrayList<>();
        left = low;
        right = mid + 1;
        
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                sorted.add(nums[left++]);
            } else {
                sorted.add(nums[right++]);
            }
        }
        
        while (left <= mid) {
            sorted.add(nums[left++]);
        }
        
        while (right <= high) {
            sorted.add(nums[right++]);
        }
        
        for (int i = low; i <= high; i++) {
            nums[i] = sorted.get(i - low);
        }
        
        return count;
    }
    
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }
}
