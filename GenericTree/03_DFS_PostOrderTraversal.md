# DFS Post Order Traversal
## Algo:
* Traverse Children
* Then Store the root
## Code:
```
class Solution {
     public void postOrder(Node root,List<Integer> tree){
        if(root == null){
            return;
        }
        for(Node child : root.children){
            postOrder(child,tree);
        }
        tree.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> tree = new ArrayList<>();
        postOrder(root,tree);
        return tree;
    } 
}
```
