# LinkedList | Reversal
## Algo:
* Take three node variables, current, temp and prev and swap accordingly by storing the link to temp variable
## Code:
```
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev,current,temp;
        prev=null;
        current=head;
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
```
