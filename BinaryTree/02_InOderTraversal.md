# InOrder Traversal 
## Algo:
* Always in ascendin order
* Go Left -> Store root -> Go right
* in case of itterative go to the left most root before storing any root node as answer
## Code: (Recursive)
```
class Solution {
    void inorder(TreeNode current,List<Integer> tree){
        if(current == null) return ;
        inorder(current.left, tree);
        tree.add(current.val);
        inorder(current.right, tree);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree =new ArrayList<>();
        inorder(root,tree);
        return tree;
    }
}
```
## Code: (Itterative)
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> tree = new ArrayList<Integer>();
        if(root == null) return tree;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            tree.add(root.val);
            root=root.right;
        }
        return tree;
    }
}
```
