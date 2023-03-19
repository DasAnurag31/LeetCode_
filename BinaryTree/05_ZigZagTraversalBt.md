# Zig-Zag Traversal BST
## Algo
* Level Order Traversal but reverse the subtree alternatingly before adding to tree
## Code
```
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        if(root == null) return tree;
        int flag=1;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> subtree = new ArrayList<>();
            int queuesize=queue.size();
            for(int i=0;i<queuesize;i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subtree.add(queue.poll().val);
            }
            if(flag ==1){
                tree.add(subtree);
                flag=0;
            }
            else{
                Collections.reverse(subtree);
                tree.add(subtree);
                flag=1;
            }
           
        }
        return tree;
    }
}
```
