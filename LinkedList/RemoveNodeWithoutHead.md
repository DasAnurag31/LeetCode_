# Linked List | Delete a node without head
## Algo :
* Replace the value of the node with the value of the next node and also it's refrence with the refrence of the next node.
## Code:
```
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
