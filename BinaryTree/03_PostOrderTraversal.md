# PostOrder Traversal
## Algo:
* Go left -> go right -> store root
* In Case of a inorder traversal take the answer when the condition ```right == null or right == prev ``` satisfies and then store it to prev else store to stack and move right
## Code:
```
class Solution {
    void traversal(TreeNode current, List<Integer> postorderTree){
        if(current == null ) return;
        traversal(current.left, postorderTree);
        traversal(current.right, postorderTree);
        postorderTree.add(current.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderTree =new ArrayList<>();
        traversal(root, postorderTree);
        return postorderTree;
    }
}
```
## Code: (Itterative)
```
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<Integer>();
        if(root == null) return tree;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev=null;
        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.right == null || root.right == prev){
                tree.add(root.val);
                prev=root;
                root=null;
               
            }
            else{
                stack.push(root);
                root=root.right;
            }
        }
        return tree;
    }
}
```
