// https://leetcode.com/problems/range-sum-of-bst/?envType=daily-question&envId=2024-01-08

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        if(root.left != null){
            sum += rangeSumBST(root.left, low, high);
        }
        if(root.right != null){
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}