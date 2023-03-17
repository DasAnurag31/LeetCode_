# Kth Smallest BST
## Algo
* Do a Inorder traversal and decrement the value of k by on ein each traversal
* return the node when k i s0 
## Code:
```
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); 
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k == 0) break;
            root=root.right;
        }
        return root.val;
    }
}
```
