class Solution {
    private int helper(int[] nums, int target, int cur, int index, int length, Map<Integer, Integer>[] memo){
        if(index == length){
            if(target == cur){
                return 1;
            }
            return 0;
        }
        if(memo[index].containsKey(cur)){
            return memo[index].get(cur);
        }
        int ans =   helper(nums, target, cur + nums[index], index+1, length, memo) + 
                    helper(nums, target, cur - nums[index], index+1, length, memo);
        memo[index].put(cur, ans);
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        int len = nums.length;
        Map<Integer, Integer>[] memo = new HashMap[len];
        for (int i = 0; i < len; i++) {
            memo[i] = new HashMap<>();
        }
        return helper(nums, target, 0, 0, len, memo);
    }
}