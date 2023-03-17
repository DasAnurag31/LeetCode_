# LCA BST
## Algo:
* At every node either both p and q will lie towards the same side for which we need to traverse to that side
* or they will lie on the oppposite side for which the current node becomes the largestr common ancestor
## Code:
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
```
