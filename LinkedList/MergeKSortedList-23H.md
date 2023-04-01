# Merge k sorted Lists | LinkedList
## Algo:
* USE divide and conquer to make a recursive tree and solve each pai rby merging twp lists and returning  a merged list
## Code:
```

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideAndConquer(lists, 0, lists.length - 1);
    }
    public ListNode divideAndConquer(ListNode[] lists,int low,int high){
        if(low>=high)
            return lists[low];
        int mid=low+(high-low)/2;
        ListNode left=divideAndConquer(lists,low,mid);
        ListNode right=divideAndConquer(lists,mid+1,high);
        return merge(left,right);
    }
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (n1!=null && n2!=null){
            if (n1.val<n2.val) {
                prev.next = n1;
                n1 = n1.next;
            }
            else{
                prev.next = n2;
                n2 = n2.next;
            }
            prev = prev.next;
        }
        if(n1!=null)
            prev.next=n1;
        if(n2!=null)
            prev.next=n2;
        return dummy.next;
    }
}
```
