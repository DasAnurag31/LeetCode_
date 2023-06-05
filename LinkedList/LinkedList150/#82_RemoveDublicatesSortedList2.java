class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        dummy.next = head;
        while(head != null){
            if(head.next != null &&  head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                    if(head.next == null){
                        dummy.next = null;
                    }
                }
                head = head.next;
                continue;
            }
            else{
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
            }

        }
        return result.next;
    }
}