# Path from root to node
## Algo:
* Take an array to store path and return false or true.
* Store the element in the array.
* Return True if the target lies in one of the subtrees or it is equal to the node.
* Else return false

## Code:
```
boolean getPath(Node root, ArrayList < Integer > arr, int x){
  if(root == null) return false;
  arr.add(root.val);
  if(root.val == x){
    return true;
  }
  if(getPath(root.left,arr,x) || getPath(root.right,arr,x)){
    return true;
  }
  arr.remove(arr.size()-1); 
  return false;
}
```
