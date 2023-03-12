## Ceil 
``` key= min(keys) && keys>=target ```
* finding the minimum values node higher or equal to the given target
``` 
while(root.val != null){ 
    if(root.val == target) return root.val;
    if(root.val > target){ ceil = root.val; root = root.left; }
    else root = root.right 
} 
```
