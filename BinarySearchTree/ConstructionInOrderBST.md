# Construction of a BST from the given inorder traversal
## ALgo 
* Method01;
  * We know than each commin gele will be larger than the present element so if we make the first ele as root and traverse right with each ele then we get a BST
  * The Bst obtained is of Height N where n is the no of nodes as the tree is degenerate in nature.
 * Method 02:
  * Take the mid ele and make it root and then go to the right with the subarray of all ele left of it and so for right 
  * Do this recursively and return the root
 ## Code;
 ```
 TreeNode solve(TreeNode inorder[], int l, int r){
  if(l>r){
    return NULL;
  }
  int m = (l+r)/2;
  TreeNode root = new TreeNode(inorder[m]);
  root->left = solve(v, l, m-1);
  root-> right = solve(v, m+1,r);
  return root;
}

TreeNode constructFromInOrder(TreeNode inorder[])
{
  return solve(inorder, 0, inorder.size()-1);
}
 ```
