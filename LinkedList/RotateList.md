# Rotate List | Linked List
## Algo:
* We know that is the value of k is equal to the length then the list will rotate back to it's original form 
* For a value greater than length for k we find out the mod of k to get actually how many nodes from the end need to be shifted
* We use the concept of the fast and the slow pointer to find the kth node from the end of the linked list 
* Then we Know the Exact place where the link will have to be broken and the next link be jined to the head to rotate the list and return the new head 
## Code:
```
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int length = 1;
        ListNode tail = head;;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        k %= length;
        if(k == 0) return head;
        length = length - k;
        ListNode cur = head;
        for(int i = 1;i < length;i++){
            cur = cur.next;
        }
        ListNode temp = cur.next;
        cur.next = null;
        tail.next = head;
        return temp;  
    }
}
```
