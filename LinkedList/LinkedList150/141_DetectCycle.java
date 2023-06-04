// Algo
// * take a slow and a fast pointer , if they meet then there is a cycle 

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow,fast;
        slow = head;
        fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}