# LinkedList | Remove Larger Nodes
## Algo :
* Reverse the list.
* Set a max and each ele should be greater than it.
* Reverse the list.
## Code :
```
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head.next==null)
            return head;
        head = reverse(head);
        ListNode current = head;
        while(current.next!=null){
            if(current.val>current.next.val){
                current.next = current.next.next;
            }
            else
                current = current.next;
        }
        return reverse(head);
    }
    ListNode reverse(ListNode head)
    {
        ListNode prev,curr,temp;
        prev = null;
        curr = head;
        
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = null;
        head = prev;
        return head;
    }
}
```
