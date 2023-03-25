# Nodes at k Dist | BT | BFS
## Algo:
* First traverse the tree and make a parent reference for each and every node and store it in a hashmap to create a link from child nodes to it's parent node. (Use Level Order Traversal)
* This way We can traverse up the tree from any node
* Now we traverse the tree agian but this time we start traversing from the TARGET
* We follow a BFS traversal to go to each and every direction one node at a time
* We Mark Each node visited in a HashMap 
* In BFS we go down by goinf left and right child nodes if they are not already visited and we go up by using the paren Reference if it is not already visited. 
*  Once we have reached Distance k, we will have all the nodes which are at that distance from the target in our queue
*  We can traverse our queue to get all the nodes and put that in our ans list.
## Code:
```
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) { 
            TreeNode current = queue.poll(); 
            if(current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root); 
        Map<TreeNode, Boolean> visited = new HashMap<>(); 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()) { 
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll(); 
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>(); 
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll(); 
            result.add(current.val);
        }
        return result;
    }
}
```
