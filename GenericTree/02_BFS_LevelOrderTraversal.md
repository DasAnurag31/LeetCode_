# Bfs Level Order Generic Tree
## Algo:
* Take a queue
* Store root in the queue
* Traverse all childrentand store them in the queue and then store the root in the subtree
* after traversing all children of all nodes in queue put the subtree in the answer
## Code:
```
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i = 0; i < level; i++) {
                Node node = queue.poll();
                if (node != null) {
                    levelNodes.add(node.val);
                    List<Node> children = node.children;
                    if (!children.isEmpty()) {
                        for(Node child: children) {
                            queue.add(child);
                        }
                    }
                }
            }
            if (!levelNodes.isEmpty()) {
                answer.add(levelNodes);
            }
        }
        return answer;
    }
}    
```
```
