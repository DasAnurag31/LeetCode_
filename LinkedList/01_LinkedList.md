# LinkedList
## Differnece between a Node and a Node Pointer 
* When we need to create a node and add it to the linked List we Create a new Node which is an Instance of the Type of Node
```
ListNode node = new ListNode();
```
* When we need a Refrence variable or a pointer to keep track of a node, we Initialize a pointer of the type of ListNode or the class defining the node 
```
ListNode nodePointer = nul;
```
## When to Create a dummy Start
* When the head pointer is tampered with in the List but we still need to keep it's refrence then we create a dummy node
```
ListNode dummy = new ListNode();
dummy.next = head;
```
## 
