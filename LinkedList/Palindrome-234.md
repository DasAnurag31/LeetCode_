# Palindrome | LinkedList
## Algo:
* Reach the Middle of the linked List
* Reverse the Second part of the Linked List
* Start the left pointer from the start and the right from the left
* itterate till right reaches null as right is alway equal or less than the left half when we divide the list
* right will be null when we reach the middle 
* check each node and return false if not equal

## Code:
```
class Solution {
    public boolean isPalindrome(ListNode head) {
        // First we Find the Middle Node
        ListNode slow,fast;
        slow = head;
        fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second part of the List
        ListNode prev,current,temp;
        prev=null;
        current=slow.next;
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        ListNode left, right;
        left = head;
        right = prev;
        while(right !=null){
            if(right.val != left.val) return false;
            else{
                right = right.next;
                left = left.next;
            }
        }
        return true;
    }
}
```
