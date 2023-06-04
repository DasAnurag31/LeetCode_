# Balanced ? Binary tree
## Algo:
* Condition for a bt to be balanced is at every rootthe left subtree height and the right subtree height should not have a difference of more than 1
* We Start off with node and check at each node and return a -1 back up as we get a non balaned node adm return the value else we retun the height tree 
 
## Code:
```
class Solution {
    public int height(TreeNode root){
        if(root == null)
            return 0;
        int left=height(root.left);
        if(left==-1) return -1;
        int right=height(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right) <=1)
            return Math.max(left,right)+1;
        return -1;
    }
    public boolean isBalanced(TreeNode root) {
        if(height(root)==-1) return false;
        return true;
    }
}
```
