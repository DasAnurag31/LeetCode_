class Solution {
    int find(int low, int high, int[] nums) {

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return mid;

            if (mid % 2 == 0) {
                if (nums[mid + 1] == nums[mid]) {
                    low = mid + 1;
                } else if (nums[mid - 1] == nums[mid]) {
                    high = mid;
                }
            }

            else {
                if (mid % 2 == 1 && nums[mid - 1] == nums[mid]) {
                    low = mid + 1;
                } else if (mid % 2 == 1 && nums[mid + 1] == nums[mid]) {
                    high = mid;
                }
            }
        }
        return -1;

    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];

        int low = 0;
        int high = nums.length - 1;
        int index = find(low, high, nums);
        return nums[index];
    }
}