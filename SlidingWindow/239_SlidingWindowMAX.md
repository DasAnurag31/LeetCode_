# SlidingWindowMAX 
## Algo
* Priority Q and nested loop solouton are TLE
* ONLY DQ sol is accepted
## Code: 'DQ'
```
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            if (q.isEmpty()) {
                q.add(nums[right]);
            }
            else {
                // checking if the upcoming element is the largest, and removing all elements till except the largest then adding the right upcoming ele
                while (!q.isEmpty() && nums[right] > q.peekLast()) {
                    q.pollLast();
                }
                q.add(nums[right]);
            }

            if (right - left + 1 == k) {
                ans[left] = q.peekFirst();
                // if the outgoing ele is the largest then remove it from the queue 
                if (nums[left] == q.peekFirst()) {
                    q.pollFirst();
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}

// TC: O(n), SC: O(k)

```
## Code: 'PQ'
```
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int left = 0, right = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        while (right < k) {
            pq.offer(nums[right++]);
        }

        int[] ans = new int[nums.length - k + 1];
        while (right < nums.length) {
            ans[left] = pq.peek();
            pq.remove(nums[left++]);
            pq.offer(nums[right++]);
        }

        ans[left] = pq.peek();
        return ans;
    }
}

// TC: O(k *  logk) + O((n - k) * logk) => O(n * logk)
// SC: O(k)
```
