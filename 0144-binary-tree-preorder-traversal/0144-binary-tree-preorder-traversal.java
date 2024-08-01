class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return tree;
        while(!stack.isEmpty() || root != null){
            while(root!=null){
                stack.push(root);
                tree.add(root.val);
                root=root.left;
            }
            root = stack.pop();
            root = root.right;            
        }
        return tree;
    }
}