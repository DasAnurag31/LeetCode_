# PreOrder Binary Tree Traversal
## Algo:
* Root -> left -> right
* Store ans -> go left -> go right
* In Case of itterative solution go to the leftmost root whenever you reach a root and then traverse the default right
* Make use of a stack
## Code:
```
class Solution {
    void preorder(TreeNode current,List<Integer> tree){
        if(current == null) return ;
        tree.add(current.val);
        preorder(current.left,tree);
        preorder(current.right,tree);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree =new ArrayList<>();
        preorder(root, tree);
        return tree;
    }
}
```
## Code: 
```

```
