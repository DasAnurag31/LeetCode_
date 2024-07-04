class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode start = head;
        ListNode prev = head;
        head = head.next;
        int sum = 0;
        while(head != null){
            if(head.val == 0){
                head.val = sum;
                sum = 0;
                prev.next = head;
                prev = head;
            }else{
                sum += head.val;
            }
            head = head.next;
        }
        return start.next;
    }
}