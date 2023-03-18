# Max Depth of a Bianry tree
## Algo:
* Add the node as 1 and then count max of left and right

## CODE:
```
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
```
