class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] prev = new int[n]; // To store the previous index in the subset
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        // Backtracking to construct the subset
        List<Integer> result = new ArrayList<>();
        while (endIndex != -1) {
            result.add(0, nums[endIndex]);
            endIndex = prev[endIndex];
        }

        return result;
    }
}