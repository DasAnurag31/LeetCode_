# Swap Nodes in Pair | LinkedList
## Algo
* We create a dummy node for storing the head 
* We take two pointers A and B to store two nodes at any point 
* We keep track or the prev of the pair and the next of the pair say P and N
* We Swap the pointers as 
	* B->N to B->A
	* A->B to A->N
	* P->A to P->B
* Then we reassign the pointers as
	* P = A
	* A = N
	* B = N.next
	* N = N.next.next
* We also take care of edge cases as 
	* When there is no node
	* When there is only one node
	* When there is odd no of nodes
	* When the list reaches the end
## Code
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode n = null,prev=null;
        ListNode a,b;
        a = head;
        b = head.next;
        prev = dummy;
        n = b.next;
        dummy = b;
        while(b!= null || n!= null)
        {
            b.next = a;
            a.next = n;
            prev.next = b;

            prev = a;
            a = n;
            if(n == null){
                break;
            }
            b = n.next;
            if(b == null){
                break;
            }
            n = b.next;
        }
        return dummy;
    }
}
```
