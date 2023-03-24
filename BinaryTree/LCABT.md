# LCA | Binary tree
## Algo:
* Check if the current node is null, return null i.e the root
* if is equal to null or one of the nodes , then we know that it is the lca therefore return it ;
* We check is the nodes are in the left and right
* if we know that the left subtree has reached the end then we know that both the nodes are in the right therefore we return the current right
* If we know that right is null then we know that it is on the left therefore we return left
* if none of the conditions are true then we know that we have reached the  lowest common ancestor
## Code:
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null)return right;
        if(right==null)return left;
        return root;
        
    }
}
```
