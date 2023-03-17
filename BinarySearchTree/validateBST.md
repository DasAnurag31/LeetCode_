# Validate a BST 
## Algo
* Method 01
  * Travers inOrder and make sure that the next element is larger than the previous else return false
* Method 02
  * Take a upper and lower range and make sure each node falls between that range 
  * The left node will always be smaller than its parent and larger than the current min
  * the right node will be always larger than the parent node and will be smaller than the current largest 
## Code:
~~~
class Solution {
    public boolean isValidBST(TreeNode root) {
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        return isValidBST(root,min,max);
    }
    public boolean isValidBST(TreeNode root,long min,long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min){
            return false;
        }
        return (isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max));
    }
}
~~~
