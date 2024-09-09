class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (prefix[i] == k) cnt++;

            if (mp.containsKey(prefix[i] - k)) {
                cnt += mp.get(prefix[i] - k);
            }
            mp.put(prefix[i], mp.getOrDefault(prefix[i], 0) + 1);
        }
        return cnt;
    }
}