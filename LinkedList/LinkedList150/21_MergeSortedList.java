    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode original = dummy;
            while(list1 != null && list2 != null){
                if(list1.val < list2.val){
                    dummy.next = new ListNode(list1.val);
                    dummy = dummy.next;
                    list1 = list1.next;
                }
                else{
                    dummy.next =new ListNode(list2.val);
                    dummy = dummy.next;
                    list2 = list2.next;
                }
            }
            if(list1 == null) dummy.next = list2;
            if(list2 == null) dummy.next = list1;
            return original.next;
        }
    }

