# Freq of Most Freq E | Sliding Window
## Concept
* Formula : Shrink window while => (nums[R] * (R-L+1) > totalSum + k)
## Code:
```
class Solution {
    public int maxFrequency(int[] nums, int k) {

       Arrays.sort(nums);
       int L = 0 , R = 0 , ans = 0;
       long totalSum = 0;

        for(R = 0; R < nums.length; R++){
            totalSum += nums[R];
            // condition to shrink window when we know that desired values cannot be achieved in k moves
            while(nums[R] * (R-L+1) > totalSum + k){
                totalSum -= nums[L];
                L++;
             }
            ans = Math.max(ans,R-L+1);
        }
        return ans;
    }
}
```
