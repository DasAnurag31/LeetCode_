# LinkedList | Reversal
## Algo:
* the Start's next will always point to the stop at the end
## Code:
```
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode stop = null;
        ListNode prev = stop;
        while (head != stop) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```
