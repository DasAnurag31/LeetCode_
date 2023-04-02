# Remove Nth node from end | Linked List
## Algo :
* We take two pointers and set them to position -1 i.e dummy 
* We make use of the fact that if we fix the fast pointer to a distance of n from the sencond pointer then and then keep their distance equal while shifting them one place each then when the fast pointer reachers the end then the slow pointer will still be n places behind hence giving us the nod en places behind from the end
* Then we take the ref of the node behind and point it to the node ahead
## Code:
```
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow,fast;
        slow = dummy;
        fast = dummy;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        while(fast != null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
```
