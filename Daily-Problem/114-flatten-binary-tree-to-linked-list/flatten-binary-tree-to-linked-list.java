class Solution {
    private TreeNode helper(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        if(leftChild != null){
            TreeNode left = helper(leftChild);
            root.right = left;
            while(left.right != null){
                left = left.right;
            }
            if(rightChild != null){
                left.right = helper(rightChild);
            }
        }
        else{
            TreeNode right = helper(root.right);
            root.right = right;
        }
        root.left = null;
        return root;
    }
    public void flatten(TreeNode root) {
        helper(root);
    }
}