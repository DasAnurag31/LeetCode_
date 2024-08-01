class Solution {
    int max = Integer.MIN_VALUE;
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int sum = left + right + root.val;
        max = Math.max(max, sum);
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}