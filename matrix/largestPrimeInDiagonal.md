# Largest Prime no In At Least one Diagonal
## Algo:
* Set a max and check at each diagonal if it's prime 

## Code:
```
class Solution {
    public int checkPrime(int val){
        if(val ==1) return 0;
        int count=0;
        for(int i =1;i<=val/2;i++){
            if(count>1) return 0;
            if(val%i == 0){
                count++;
            }
        }
        if(count ==1)
            return val;
        else
            return 0;
    }
    public int diagonalPrime(int[][] nums) {
        int m;
        int max =0;
        m= nums.length;    
        for(int i=0;i<m;i++){
            if(max< nums[i][i] || max < nums[i][nums.length-i-1]){
                 max = Math.max(max,checkPrime(nums[i][i]));
            max = Math.max(max,checkPrime(nums[i][nums.length-i-1]));
            }
           
        }
        return max;
    }
}
```
