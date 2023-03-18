# Binary-Tree | Depth | Diameter
## Key-points :
* Use the same depth algo
* use array to store max as  array is passed by ref
* Calculate the max depth at each root-Child and then all both left and right ( dont add one to it )
* Store the calculated value in max if it is greater than max

Code: 
```
class Solution {
    public int height(TreeNode root, int[] max){
        if(root == null) return 0;
        int left=height(root.left,max); height of left subtree starting from the left child node
        int right =height(root.right,max);
        max[0]=Math.max(max[0], right+left); // note that the path length is the no of edges between the nodes and therefore foes not count the nodes
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        height(root,max);
        return max[0];
    }
}
```
