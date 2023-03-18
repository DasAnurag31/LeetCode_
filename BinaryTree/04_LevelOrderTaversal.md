# BFS or Level Order Traversal of Binart Tree
## Algo :
* Make use of a queue
* Store the root in the element 
* traverse the children (left then right) and store them in the queue
* After traversal of the childrens move the root to the subtree and do the same with the next element of the queue
## Code:
```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<List<Integer>> wrapList=new LinkedList<List<Integer>>();
        if(root==null){
            return wrapList;
        }
        // Add the root Element in Queue
        que.offer(root);
        while(!que.isEmpty()){
            // Sub List To Store Values
            List<Integer> subList=new LinkedList<>(); 
            // Run Loop Till Level Num (Basically Number of Ancestor)
            int LevelNum=que.size();
            for(int i = 0; i <LevelNum ; i++){
                // If left and rigth Values Exist It will add them 
                if(que.peek().left!=null){
                    que.offer(que.peek().left);
                }
                if (que.peek().right!=null){
                    que.offer(que.peek().right);
                }
                // Add the First Element removes it
                subList.add(que.poll().val);
            }
            // Add Sub List Values in Main
            wrapList.add(subList);
        }
        return wrapList;
    }
}
```
