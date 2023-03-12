# Binary Search TREE | Search
## Code:
* Itterative Solution
```
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val) return root;
            else if(root.val < val) root = root.right;
            else root = root.left;
        }
        return null;
    }
}
```
* Recursive Solution
```
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
       if(root.val == val) return root;
       if(root.val < val && root.right != null) return searchBST(root.right,val);
       if(root.val > val && root.left != null) return searchBST(root.left,val);
       return null;
    }
}
```
