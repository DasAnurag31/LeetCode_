# Binary Tree | Max Path Sum | Depth
## Key points :
* Calculate the sum of right and left and conside only positive values else it will effect the value.
* Algorithm : Max sum = node value + left node + right node 
* If all nodes are negative then we return the single node with least value as we still consider the node value and left and right are 0 since negative
* use a global variable to ignore taking a refrence variable

## Code :
```
class Solution {
    int max=Integer.MIN_VALUE;
    public int path(TreeNode root){
        if(root == null) return 0;
        int left=Math.max(0,path(root.left));
        int right=Math.max(0,path(root.right));
        max=Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        path(root);
        return max;
    }
}
```
