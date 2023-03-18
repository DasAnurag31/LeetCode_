# Usefull Patterns
## Using a helper height function
* To calculate the heigts used up in the binary tree algos we can use the helper height function and then modify it 
```
Height(root)
  left = Height(root.L)
  right = Height(root.R)
  return 1 + MAX( left , right )
```
* Add more functions to it instead of adding it to other function 

##
