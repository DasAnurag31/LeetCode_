# Construction of BST-PreOrder
## Algo:
* Take a upper and a lower bound 
* Traverse the given array 
* Make a node for each element and make it root if it falls inside the range else check if it fits the left or right of the root 
* We can also use only the upper bound in case of preorder as if i tis not the left then it has to lie on its right side as it cant be the root (Preorder -> Root -> Left -> Right) and we always know the root is the first element of the array so we know the upper bound of the left 
* This workd because the nodes are given in the array accordingly level wise all left then right 
## Code:
```
lass Solution {
    int nodeIndex;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) {
            return null;
        }
        nodeIndex = 0;
        return bstHelper(preorder, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    private TreeNode bstHelper(int[] preorder, int start, int end) {
        if(nodeIndex == preorder.length || preorder[nodeIndex]<start || preorder[nodeIndex]>end) {
            return null;
        }
        int val = preorder[nodeIndex++];
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);
        return node;   
    }   
} 
```
## With Only Upper Bound
```
class Solution {
int i = 0;
    public TreeNode bstFromPreorder(int[] arr) {
        return helper(arr, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] arr, int bound) {
        if (i == arr.length || arr[i] > bound) return null;
        TreeNode root = new TreeNode(arr[i++]);
        root.left = helper(arr, root.val);
        root.right = helper(arr, bound);
        return root;
    }
	}
```
