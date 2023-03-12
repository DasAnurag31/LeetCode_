# Binary Search Tree | Deletion
## Algo
* Store the refrence of the original tree in a variable
* Find the root to be deleted  : "KEY"
* Take the left of the key and join it to the left most node of the right of the key 
* Replace the key with the right of the key
## Code:
* Itterative
```
class Solution {
    public TreeNode helper(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null) return root.right;
        if(right == null) return root.left;
        while(right.left != null){
            right=right.left;
        }
        right.left=left;
        return root.right;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode Original = root;
        if(root.val == key){
            return helper(root);
        }
        while(root != null){
            if(root.val < key){
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
            else{
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
        }
        return Original;
    }
}
```
* Recursive 
```
class Solution {
    public TreeNode helper(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null) return root.right;
        if(right == null) return root.left;
        while(right.left != null){
            right=right.left;
        }
        right.left=left;
        return root.right;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode Original = root;
        if(root.val == key){
            return helper(root);
        }
        if(root.val < key){
           root.right = deleteNode(root.right,key);
        }
        else{
            root.left = deleteNode(root.left,key);
        }
        return Original;
    }
}
```
