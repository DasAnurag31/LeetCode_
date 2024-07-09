class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, ans, ds, 0);
        return ans;
    }
    
    public void combination(int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            ds.add(candidates[i]);
            combination(candidates, target - candidates[i], ans, ds, i + 1);
            ds.remove(ds.size() - 1);
        }
    }
}
