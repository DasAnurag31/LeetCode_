class Solution {
    private int result = 0;
    private boolean isPalindrome(int[] counter) {
        int odd = 0;
        for (int c: counter) {
            if (c % 2 == 1)
                odd++;
            if (odd > 1)
                return false;
        } 
        return true;
    }
    private void dfs(int[] counter, TreeNode node) {
        if (node == null){
            return;
        }
        int val = node.val;
        counter[val - 1]++;
        if (node.left == null && node.right == null && isPalindrome(counter)){
            result++;
        }
        dfs(counter, node.left);
        dfs(counter, node.right);
        counter[val - 1]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(new int[9], root);
        return result;
    }
}