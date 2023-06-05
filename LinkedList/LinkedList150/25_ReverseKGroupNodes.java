class Solution {
    private ListNode getGroupEnd(ListNode head, int k) {
        while (head != null && --k > 0)
            head = head.next;
        return head;
    }
    private ListNode reverseList(ListNode head, ListNode stop) {
        ListNode prev = stop;
        while (head != stop) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while(head != null){
            ListNode groupStart = head;
            ListNode groupEnd = getGroupEnd(head, k);

            if (groupEnd == null)
                break;

            prevGroupTail.next = reverseList(groupStart, groupEnd.next);
            prevGroupTail = groupStart;
            head = prevGroupTail.next;
        }
        return dummy.next;
    }
}