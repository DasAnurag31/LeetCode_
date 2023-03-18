# DFS PreOrder Traversal
## Algo:
* Root -> Children
* Store the root val then traverse and make each child root one by one
## Code: 
```
class Solution {
    void preorder(Node root, List<Integer> tree){
        if(root == null) return;
        tree.add(root.val);
        for(Node child : root.children){
            preorder(child,tree);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> tree = new ArrayList<>();
        preorder(root, tree);
        return tree;
    }
}
```
## Code: (Itterative)
```

```
