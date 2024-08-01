/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private  TreeNode store;
    public void helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            store = root;
            return;
        }
        
        if (root.left != null) {
            helper(root.left);
        }
        
        TreeNode temp = root.right;
        
        if (store != null) {
            root.right = root.left;
            store.right = temp;
        }
        
        root.left = null;
        
        if (temp != null) {
            store = null;
            helper(temp);
        }
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
       
        helper(root);
    }
}