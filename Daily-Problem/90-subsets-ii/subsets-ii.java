class Solution {
    public List<List<Integer>> subsetsWithDup(final int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(final int[] nums, final int idx, final List<Integer> curr, final List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        
        for(int i = idx; i < nums.length; ++i) {
            if(i != idx && nums[i - 1] == nums[i])
                continue;

            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}