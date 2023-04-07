# Product of Self | Prefix-Suffix | Array
## Algo : 
* Take Two Arrays Prefix & Suffix to calculate all the product of the left & right for each index and store it in an array
* Muliply left and right for each num 
### No Extra Space
* For no Extra space calculate the left prefix in result array 
* For the final result calculate the final as result and right post variable
## Code:
```
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left ,1);
        Arrays.fill(right ,1);
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1] * nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            right[i]=nums[i+1] * right[i+1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=left[i] * right[i];
        }
        return nums;
    }
}
```
## Code:
```
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int pre = 1;
        int post = 1;
        result[0]=1;
        for(int i=0;i<nums.length-1;i++){
           pre *= nums[i];
           result[i+1] = pre;
        }
        for(int i=nums.length-2;i>=0;i--){
           post *= nums[i+1];
           result[i] = post * result[i];
        }
        return result;
    }
}
```

