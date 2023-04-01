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
## Reaching the Middle of a Linked List
* Use of a slow and a fast pointer where 
```
slow = head;
fast = head.next;
```
* Increment the slow by one and the fast by two 
* When the fast reaches the end OR null then we know that the slow has reached the middle point 
* When dividing an array the Second part of the array starts from the next node of the slow pointer
* A->B->C->D = slow is B and Fast is D
* A->B->C->D->E = slow is C and Fast is null
* The right list is always equal to or is less than the left list
## Reversing the Linked List
* Take Three Variables Current Prev and Next and swap the links accordingly
