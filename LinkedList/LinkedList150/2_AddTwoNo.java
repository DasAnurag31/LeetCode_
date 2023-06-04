// Algo :
// * Itterate the list until one of them is not null and their exists a carry 

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null || carry != 0){
            sum += carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum > 9){
                carry = sum / 10;
                result.next = new ListNode(sum % 10);
                result = result.next;

            }else{
                carry = 0;
                result.next = new ListNode(sum);
                result = result.next;
            }
            sum = 0;
        }
        return current.next;
    }
}
