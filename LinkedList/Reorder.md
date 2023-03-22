# LinkedList | Reorder 
## Algo :
* First find the middle 
* Break the list into two parts and reverse the second list
* Merge the two lists accordingly
## Code:
```
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow,fast,second,prev,temp,current,tempA,tempB;
        slow = head;
        fast = head.next;
        // Finding the mid point of the linked List
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Slow is the mid point and second is the head of the second part of the linkedList
        second = slow.next;
        slow.next = null;
        // Reverse the second Linked list
        prev = null;
        while(second != null){
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        // Second head is now at it's correct position
        // Reordering the Linked List
        current = head;
        second = prev;
        while(second != null){
            tempA = current.next;
            tempB = second.next;
            current.next = second;
            second.next = tempA;
            current = tempA;
            second = tempB;
        }
    }
}
```
