 class Pair {
    TreeNode node; 
    int index; 
    Pair(TreeNode _node, int _index) {
        index = _index;
        node = _node; 
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(root, 0)); 
        while(!q.isEmpty()){
            int size = q.size();
            // int min = q.peek().index;    
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int ind = q.peek().index;
                // int ind = q.peek().index - min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0){
                    first = ind;
                } 
                if(i==size-1){
                    last = ind;
                } 
                if(node.left != null)
                    q.offer(new Pair(node.left, ind * 2 + 1));
                if(node.right != null) 
                    q.offer(new Pair(node.right, ind * 2 + 2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}