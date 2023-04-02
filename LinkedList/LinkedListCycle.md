# Linked list Cycle 
## Algo:
* Take a slow and a fast pointer 
* If a cycle exists then fast or fast.next willl reach a null value 
* Else we know that there exists a loop
## Code:
```
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow,fast;
        ListNode dummy = new ListNode();
        slow = head;
        fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
```
