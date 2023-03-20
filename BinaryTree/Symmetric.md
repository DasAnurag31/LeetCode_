# Symmetric ? BT
## Algo:
* If at each root its left and right is equal then it is sym
* if its left->left and right->right is equal and left->right and right->left is equal then we can say they are mirro images
## Code:
```
class Solution {
    public boolean sym(TreeNode left,TreeNode right)
    {
        if(left == null || right == null) return left==right;
        if(left.val != right.val) return false;
        return sym(left.left,right.right) && sym(left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return sym(root.left,root.right);
    }
}
```
