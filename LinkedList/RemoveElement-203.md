# Remove Elements | LinkedList 
## Algo 
*  create a dummy node and itterare over
*  if the value matches the target value then you change the prev pointer else increment 

## Code
```
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur, prev;
        cur = head;
        prev = dummy;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
```
