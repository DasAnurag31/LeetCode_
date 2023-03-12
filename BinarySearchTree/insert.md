# Binary Search Tree | Insertion 
## Code:
* Itterative 
```
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return root = new TreeNode(val);
        TreeNode cur = root;
        while(true){
            if(val > cur.val){
                if(cur.right == null)
                {
                    cur.right = new TreeNode(val);
                    break;
                }
                else{
                    cur = cur.right;
                }
            }
            else{
                if(cur.left == null)
                    {
                        cur.left = new TreeNode(val);
                        break;
                    }
                    else{
                        cur = cur.left;
                    }
            }
        }
        return root;
    }
}
```
* Recursive 
```
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val) root.right = insertIntoBST(root.right,val);
        else root.left = insertIntoBST(root.left,val);
        return root;
    }
}
```
