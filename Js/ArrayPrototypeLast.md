# Array ProtoType last
## Algo :
* Return the Last Element present in the array 
## Learnings:
* `??` Operator : 
	* Syntax : `leftExpr ?? rightExpr`
	* Returns the left if not null ro undefined else returns the left side.
## Code:
```
Array.prototype.last = function() {
    return this[this.length - 1] ?? -1;
};
```
