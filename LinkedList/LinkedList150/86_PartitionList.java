class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode c1 = l1;
        ListNode c2 = l2;
        while(head != null){
                if(head.val < x){
                l1.next = head;
                l1 = l1.next;
                head= head.next;
                }
                else{
                l2.next = head;
                l2 = l2.next;
                head = head.next;
                }
        }
        l2.next = null;
        l1.next = c2.next;
        return c1.next;
    }
}