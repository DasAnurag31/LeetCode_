# Binary Tree | Check Identical 
## Key Points:
* Use any traversal and check at each point
* Return form helper function 0 
* Return -1 from helper function if at any point 
## Code:
```
class Solution {
    public int preorder(TreeNode p, TreeNode q){
        if(p==null && q==null ) return 0;
        if(p== null && q!=null) return -1;
        if(q==null && p!=null) return -1;
        if(p.val != q.val)
        {
            return -1;
        }
        if(preorder(p.left,q.left)==-1) return -1;
        if(preorder(p.right,q.right) ==-1) return -1; 
        return 0;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(preorder(p,q)==-1) return false;
        return true;
    }
}
```
