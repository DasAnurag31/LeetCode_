class Solution {
    private boolean dfs(String s, int prev, int cur, Set<String> wordDict, Set<Integer> visited) {
        if (cur == s.length()) {
            return true;
        }
        if (visited.contains(prev)) {
            return false;
        }
        for (int i = cur; i <= s.length(); i++) {
            String partition = s.substring(prev, i);
            if (wordDict.contains(partition)) {
                if (dfs(s, i, i, wordDict, visited)) {
                    return true;
                }
            }
        }
        visited.add(prev);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Set<Integer> visited = new HashSet<>();
        return dfs(s, 0, 0, wordSet, visited);
    }
} 